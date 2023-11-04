package com.sprintform.hw.client.controller.base;

import com.sprintform.hw.application.mapper.base.EntityMapper;
import com.sprintform.hw.application.model.entity.base.BaseEntity;
import com.sprintform.hw.application.service.base.BaseCrudService;
import com.sprintform.hw.application.service.base.CrudService;
import com.sprintform.hw.client.dto.base.BaseUpdateRequest;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author peti
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter
public abstract class BaseCrudController<E extends BaseEntity,
        C,
        R,
        U extends BaseUpdateRequest,
        L,
        F> {

    CrudService<E, F> service;

    EntityMapper<E, C, R, U, L> mapper;

    @PostMapping
    public R create(@Valid @RequestBody C request) {
        return mapper.mapEntityToReadResponse(service.create(mapper.mapCreateRequestToEntity(request)));
    }

    @GetMapping("/{id}")
    public R read(@PathVariable UUID id) {
        return mapper.mapEntityToReadResponse(service.read(id));
    }

    @PutMapping
    public R update(@Valid @RequestBody U request) {
        return mapper.mapEntityToReadResponse(service.update(mapper.mapUpdateRequestToEntity(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @GetMapping
    public Page<L> list(Pageable pageable, F filter) {
        return  service.list(pageable, filter).map(mapper::mapEntityToListResponse);
    }
}
