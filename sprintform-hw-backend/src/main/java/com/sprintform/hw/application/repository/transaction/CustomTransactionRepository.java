package com.sprintform.hw.application.repository.transaction;

import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.client.dto.transaction.ForecastResponse;
import com.sprintform.hw.client.dto.transaction.TransactionStatisticsResponse;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Additional repository operations, like statistics aggregation and forecast.
 * @author zellerpeter
 */
public interface CustomTransactionRepository {

    /**
     * Calculates the aggregated statistics by Transaction category.
     *
     * @param specification filter conditions
     * @return List of aggregated Transaction statistics
     */
    List<TransactionStatisticsResponse> calculateStatistics(Specification<Transaction> specification);

    /**
     * Calculates a forecast based on the average of the last given months.
     *
     * @param months last months to calculate the average for
     * @return average spending of the last given months
     */
    ForecastResponse calculateForecast(final Integer months);
}
