package com.sprintform.hw.application.repository.transaction;

import com.sprintform.hw.application.model.entity.base.BaseEntity;
import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.client.dto.transaction.ForecastResponse;
import com.sprintform.hw.client.dto.transaction.TransactionStatisticsResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author zellerpeter
 */
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CustomTransactionRepositoryImpl implements CustomTransactionRepository {

    EntityManager entityManager;

    @Override
    public List<TransactionStatisticsResponse> calculateStatistics(final Specification<Transaction> specification) {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<TransactionStatisticsResponse> criteriaQuery = cb.createQuery(TransactionStatisticsResponse.class);

        final Root<Transaction> root = criteriaQuery.from(Transaction.class);

        criteriaQuery.multiselect(root.get(Transaction.Fields.category),
                cb.sum(root.get(Transaction.Fields.sum)),
                cb.count(root.get(BaseEntity.Fields.id)));

        criteriaQuery.groupBy(root.get(Transaction.Fields.category));

        criteriaQuery.where(specification.toPredicate(root, criteriaQuery, cb));

        final TypedQuery<TransactionStatisticsResponse> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public ForecastResponse calculateForecast(final Integer months) {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<ForecastResponse> criteriaQuery = cb.createQuery(ForecastResponse.class);

        final Root<Transaction> root = criteriaQuery.from(Transaction.class);

        criteriaQuery.multiselect(cb.avg(root.get(Transaction.Fields.sum)));

        final ZonedDateTime monthFilterValue = ZonedDateTime.now().minusMonths(months).truncatedTo(ChronoUnit.DAYS);

        criteriaQuery.where(cb.greaterThanOrEqualTo(root.get(Transaction.Fields.paidAt), monthFilterValue));

        final TypedQuery<ForecastResponse> query = entityManager.createQuery(criteriaQuery);

        return query.getSingleResult();
    }
}
