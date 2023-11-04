package com.sprintform.hw.client.controller.transaction;

import com.sprintform.hw.application.mapper.transaction.TransactionMapper;
import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.application.service.transaction.TransactionService;
import com.sprintform.hw.client.controller.base.BaseCrudController;
import com.sprintform.hw.client.dto.transaction.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.server.PathParam;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author peti
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

    @GetMapping("/statistics")
    public List<TransactionStatisticsResponse> statistics(@Valid TransactionStatisticsFilter filter) {
        final TransactionService service = (TransactionService) getService();

        return service.findStatistics(filter);
    }

    @GetMapping("/forecast")
    public ForecastResponse forecast(@RequestParam Integer months) {
        final TransactionService service = (TransactionService) getService();

        return service.calculateForecast(months);
    }
}
