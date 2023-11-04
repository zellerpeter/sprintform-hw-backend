package com.sprintform.hw.application.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

/**
 * Base interface for crud operations.
 * @author peti
 */
public interface CrudService <E, F> {

    E create(E data);

    E read(UUID id);

    E update(E data);

    void delete(UUID id);

    Page<E> list(Pageable pageable, F filter);
}
