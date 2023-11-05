package com.sprintform.hw.application.repository.specification.transaction;

import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.application.repository.specification.base.BaseListSpecification;
import com.sprintform.hw.client.dto.base.FilterRange;
import com.sprintform.hw.client.dto.transaction.TransactionListFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

import static com.sprintform.hw.application.repository.specification.base.SpecificationHelper.addLikeFilterFor;
import static com.sprintform.hw.application.repository.specification.base.SpecificationHelper.addRangeFilterFor;

/**
 * Filter conditions for transaction listing.
 *
 * @author zellerpeter
 */
@Component
public class TransactionListSpecification implements BaseListSpecification<Transaction, TransactionListFilter> {

    @Override
    public Specification<Transaction> getListFilterSpecification(final TransactionListFilter filter) {
        return Specification.where(
                (root, query, criteriaBuilder) -> {

                    final Collection<Predicate> predicates = new ArrayList<>();

                    addLikeFilterFor(Transaction.Fields.summary, filter.getSummaryFilter(), criteriaBuilder, root, predicates);
                    addLikeFilterFor(Transaction.Fields.category, filter.getCategoryFilter(), criteriaBuilder, root, predicates);
                    addLikeFilterFor(Transaction.Fields.currency, filter.getCurrencyFilter(), criteriaBuilder, root, predicates);

                    addRangeFilterFor(Transaction.Fields.sum, new FilterRange<>(filter.getSumFrom(), filter.getSumTo()), criteriaBuilder, root, predicates);
                    addRangeFilterFor(Transaction.Fields.paidAt, new FilterRange<>(filter.getPaidAtFrom(), filter.getPaidAtTo()), criteriaBuilder, root, predicates);

                    return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
                });
    }
}
