package com.sprintform.hw.application.repository.base;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author peti
 */
@NoRepositoryBean
public interface FilterableJpaRepository<E> extends JpaRepository<E, UUID> {

    /**
     * Returns a {@code Page} of entities meeting the paging restriction provided in the {@link
     * Pageable} parameter and the filtering restriction provided in the {@link Specification}
     * parameter.
     * @param specification specification
     * @param pageable pageable
     * @return the filtered page of entities
     */
    @Transactional(readOnly = true)
    Page<E> findAll(@NotNull Specification<E> specification, @NotNull Pageable pageable);

    /**
     * Removes entity by the provided id.
     *
     * <p>It may be used instead of {@link JpaRepository#deleteById(Object)} because this method
     * doesn't throw exception if entity doesn't exist with the provided id.
     * @param id unique identifier of the entity
     * @return 1 if the entity existed, 0 otherwise.
     */
    @Transactional
    int removeById(UUID id);
}
