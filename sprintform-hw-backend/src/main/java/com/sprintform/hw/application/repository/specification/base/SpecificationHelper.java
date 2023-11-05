package com.sprintform.hw.application.repository.specification.base;

import com.sprintform.hw.client.dto.base.FilterRange;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.Collection;

/**
 * Utility methods for filter conditions for specifications.
 * @author zellerpeter
 */
public final class SpecificationHelper {

    private static final String WILDCARD = "%";

    private SpecificationHelper() {

    }

    /**
     * Adds a case-insensitive like filter for a given field.
     *
     * @param fieldName name of the field to filter
     * @param value value to filter for
     * @param builder criteria builder
     * @param root root
     * @param predicates collection of expressions
     */
    public static void addLikeFilterFor(final String fieldName, final String value, final CriteriaBuilder builder,
                                        final Root<?> root, Collection<Predicate> predicates) {
        if (value != null) {
            predicates.add(builder.like(builder.upper(root.get(fieldName)), getLikeFilterValue(value)));
        }
    }

    /**
     * Adds a range filter for a given field.
     *
     * @param fieldName name of the field to filter
     * @param range interval of values to filter for
     * @param builder criteria builder
     * @param root root
     * @param predicates collection of expressions
     * @param <T> type of the field, must be a comparable type
     */
    public static <T extends Comparable<? super T>> void addRangeFilterFor(final String fieldName,
                                                                           final FilterRange<T> range,
                                                                           final CriteriaBuilder builder,
                                                                           final Root<?> root,
                                                                           final Collection<Predicate> predicates) {
        if (range != null) {
            if (range.getFrom() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get(fieldName), range.getFrom()));
            }

            if (range.getTo() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get(fieldName), range.getTo()));
            }
        }
    }

    private static String getLikeFilterValue(final String value) {
        return WILDCARD + value.toUpperCase() + WILDCARD;
    }
}
