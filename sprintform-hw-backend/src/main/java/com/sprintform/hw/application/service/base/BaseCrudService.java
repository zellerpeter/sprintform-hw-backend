package com.sprintform.hw.application.service.base;

import com.sprintform.hw.application.model.entity.base.BaseEntity;
import com.sprintform.hw.application.repository.base.FilterableJpaRepository;
import com.sprintform.hw.application.repository.specification.base.BaseListSpecification;
import com.sprintform.hw.infrastructure.error.ApplicationException;
import com.sprintform.hw.infrastructure.error.ErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Base service implementation for crud operations and list with filtering.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter
public abstract class BaseCrudService<E extends BaseEntity, F>
        implements CrudService<E, F> {

    FilterableJpaRepository<E> repository;

    BaseListSpecification<E, F> specification;

    /**
     * Update operation implementation needs to be provided by the subclass.
     * @param from source entity
     * @param target target entity
     * @return updated entity
     */
    protected abstract E update(final E from, final E target);

    @Override
    public E create(final E data) {
        return repository.save(data);
    }

    @Override
    public E read(final UUID id) {
        return findEntity(id);
    }

    @Transactional
    @Override
    public E update(final E data) {
        final E entity = findEntity(data.getId());
        return repository.save(update(data, entity));
    }

    @Override
    public void delete(final UUID id) {
        repository.removeById(id);
    }

    @Override
    public Page<E> list(Pageable pageable, F filter) {
        return repository.findAll(specification.getListFilterSpecification(filter), pageable);
    }

    private E findEntity(final UUID id) {
        return repository.findById(id).orElseThrow(() -> new ApplicationException(ErrorCode.ENTITY_NOT_FOUND));
    }
}
