package com.sprintform.hw.client.controller.transaction;

import com.sprintform.hw.application.mapper.transaction.TransactionMapper;
import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.application.service.transaction.TransactionService;
import com.sprintform.hw.client.controller.base.BaseCrudController;
import com.sprintform.hw.client.dto.transaction.*;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for Transaction API endpoint.
 *
 * @author zellerpeter
 */
@RestController
@RequestMapping("/transaction")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TransactionController extends BaseCrudController<Transaction,
        CreateTransactionRequest,
        ReadTransactionResponse,
        UpdateTransactionRequest,
        ListTransactionResponse,
        TransactionListFilter> {

    public TransactionController(final TransactionService service, final TransactionMapper mapper) {
        super(service, mapper);
    }

    /**
     * Aggregated statistics by transaction category.
     *
     * @param filter filter conditions
     * @return list of aggregated statistics
     */
    @GetMapping("/statistics")
    public List<TransactionStatisticsResponse> statistics(@Valid TransactionStatisticsFilter filter) {
        final TransactionService service = (TransactionService) getService();

        return service.calculateStatistics(filter);
    }

    /**
     * Forecast by calculating the average spending of the last given months.
     * @param months months to calculate the average for
     * @return average spending
     */
    @GetMapping("/forecast/{months}")
    public ForecastResponse forecast(@PathVariable Integer months) {
        final TransactionService service = (TransactionService) getService();

        return service.calculateForecast(months);
    }
}
