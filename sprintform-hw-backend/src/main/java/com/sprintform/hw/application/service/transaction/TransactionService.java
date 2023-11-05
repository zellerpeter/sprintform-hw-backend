package com.sprintform.hw.application.service.transaction;

import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.application.service.base.CrudService;
import com.sprintform.hw.client.dto.transaction.ForecastResponse;
import com.sprintform.hw.client.dto.transaction.TransactionListFilter;
import com.sprintform.hw.client.dto.transaction.TransactionStatisticsFilter;
import com.sprintform.hw.client.dto.transaction.TransactionStatisticsResponse;

import java.util.List;

/**
 * Service for Transaction operations.
 *
 * @author zellerpeter
 */
public interface TransactionService extends CrudService<Transaction, TransactionListFilter> {

    /**
     * Calculates the aggregated statistics by Transaction category.
     *
     * @param filter filter conditions
     * @return List of aggregated Transaction statistics
     */
    List<TransactionStatisticsResponse> calculateStatistics(TransactionStatisticsFilter filter);

    /**
     * Calculates a forecast based on the average of the last given months.
     *
     * @param months last months to calculate the average for
     * @return average spending of the last given months
     */
    ForecastResponse calculateForecast(final Integer months);
}
