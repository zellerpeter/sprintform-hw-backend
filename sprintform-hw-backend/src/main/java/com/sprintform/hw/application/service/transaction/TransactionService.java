package com.sprintform.hw.application.service.transaction;

import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.application.service.base.CrudService;
import com.sprintform.hw.client.dto.transaction.ForecastResponse;
import com.sprintform.hw.client.dto.transaction.TransactionListFilter;
import com.sprintform.hw.client.dto.transaction.TransactionStatisticsFilter;
import com.sprintform.hw.client.dto.transaction.TransactionStatisticsResponse;

import java.util.List;

/**
 * @author peti
 */
public interface TransactionService extends CrudService<Transaction, TransactionListFilter> {

    List<TransactionStatisticsResponse> findStatistics(TransactionStatisticsFilter filter);

    ForecastResponse calculateForecast(final Integer months);
}
