package com.sprintform.hw.application.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

/**
 * Base interface for crud operations.
 *
 * @author zellerpeter
 */
public interface CrudService <E, F> {

    /**
     * Creates an entity from the incoming request data.
     *
     * @param data request
     * @return entity
     */
    E create(E data);

    E read(UUID id);

    /**
     * Updates an existing entity from the incoming request data.
     *
     * @param data request
     * @return entity
     */
    E update(E data);

    /**
     * Deletes an entity by it's unique identifier.
     * @param id identifier
     */
    void delete(UUID id);

    /**
     * Lists entities with the given filter conditions.
     * @param pageable pageable for paging purposes (pagination, ordering)
     * @param filter filter conditions
     * @return List of entities
     */
    Page<E> list(Pageable pageable, F filter);
}
