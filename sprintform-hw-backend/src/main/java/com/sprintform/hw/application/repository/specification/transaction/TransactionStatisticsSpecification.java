package com.sprintform.hw.application.repository.specification.transaction;

import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.application.repository.specification.base.BaseListSpecification;
import com.sprintform.hw.client.dto.base.FilterRange;
import com.sprintform.hw.client.dto.transaction.TransactionListFilter;
import com.sprintform.hw.client.dto.transaction.TransactionStatisticsFilter;
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
 * @author peti
 */
@Component
public class TransactionStatisticsSpecification implements BaseListSpecification<Transaction, TransactionStatisticsFilter> {

    @Override
    public Specification<Transaction> getListFilterSpecification(final TransactionStatisticsFilter filter) {
        return Specification.where(
                (root, query, criteriaBuilder) -> {

                    final Collection<Predicate> predicates = new ArrayList<>();

                    addLikeFilterFor(Transaction.Fields.category, filter.getCategory(), criteriaBuilder, root, predicates);

                    return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
                });
    }
}
