package com.sprintform.hw.application.mapper.transaction;

import com.sprintform.hw.application.mapper.base.EntityMapper;
import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.client.dto.transaction.CreateTransactionRequest;
import com.sprintform.hw.client.dto.transaction.ListTransactionResponse;
import com.sprintform.hw.client.dto.transaction.ReadTransactionResponse;
import com.sprintform.hw.client.dto.transaction.UpdateTransactionRequest;
import org.mapstruct.Mapper;

/**
 * @author peti
 */
@Mapper
public interface TransactionMapper extends EntityMapper<Transaction,
        CreateTransactionRequest,
        ReadTransactionResponse,
        UpdateTransactionRequest,
        ListTransactionResponse> {

}
