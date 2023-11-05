package com.sprintform.hw.application.service.transaction;

import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.application.repository.specification.transaction.TransactionListSpecification;
import com.sprintform.hw.application.repository.specification.transaction.TransactionStatisticsSpecification;
import com.sprintform.hw.application.repository.transaction.CustomTransactionRepository;
import com.sprintform.hw.application.repository.transaction.TransactionRepository;
import com.sprintform.hw.application.service.base.BaseCrudService;
import com.sprintform.hw.client.dto.transaction.ForecastResponse;
import com.sprintform.hw.client.dto.transaction.TransactionListFilter;
import com.sprintform.hw.client.dto.transaction.TransactionStatisticsFilter;
import com.sprintform.hw.client.dto.transaction.TransactionStatisticsResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TransactionService implementation.
 *
 * @author zellerpeter
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TransactionServiceImpl extends BaseCrudService<Transaction, TransactionListFilter>
        implements TransactionService {

    CustomTransactionRepository customTransactionRepository;

    TransactionStatisticsSpecification statisticsSpecification;

    public TransactionServiceImpl(final TransactionRepository repository,
                                  final TransactionListSpecification specification,
                                  final CustomTransactionRepository customTransactionRepository,
                                  final TransactionStatisticsSpecification statisticsSpecification) {
        super(repository, specification);
        this.customTransactionRepository = customTransactionRepository;
        this.statisticsSpecification = statisticsSpecification;
    }

    @Override
    protected Transaction update(final Transaction from, final Transaction target) {
        return target.toBuilder()
                .summary(from.getSummary())
                .category(from.getCategory())
                .sum(from.getSum())
                .currency(from.getCurrency())
                .paidAt(from.getPaidAt())
                .build();
    }

    @Override
    public List<TransactionStatisticsResponse> calculateStatistics(final TransactionStatisticsFilter filter) {
        return customTransactionRepository.calculateStatistics(statisticsSpecification.getListFilterSpecification(filter));
    }

    @Override
    public ForecastResponse calculateForecast(final Integer months) {
        return customTransactionRepository.calculateForecast(months);
    }
}
