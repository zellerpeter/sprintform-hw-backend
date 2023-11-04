package com.sprintform.hw.application.repository.transaction;

import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.client.dto.transaction.ForecastResponse;
import com.sprintform.hw.client.dto.transaction.TransactionStatisticsResponse;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * @author peti
 */
public interface CustomTransactionRepository {

    List<TransactionStatisticsResponse> findStatistics(Specification<Transaction> specification);

    ForecastResponse calculateForecast(final Integer months);
}
