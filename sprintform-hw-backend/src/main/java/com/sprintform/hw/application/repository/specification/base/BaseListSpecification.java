package com.sprintform.hw.application.repository.specification.base;

import org.springframework.data.jpa.domain.Specification;

/**
 * Specification for list filtering.
 * @author zellerpeter
 */
public interface BaseListSpecification<E, F> {

    /**
     * Returns a {@link Specification} containing the built filter query.
     *
     * @param filter Parameters for filtering
     * @return The filter query
     */
    Specification<E> getListFilterSpecification(F filter);
}
