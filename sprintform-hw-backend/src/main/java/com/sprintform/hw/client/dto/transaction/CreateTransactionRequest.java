package com.sprintform.hw.client.dto.transaction;

import com.sprintform.hw.application.model.entity.transaction.TransactionCategoryType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;

/**
 * Create request for transactions.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@Getter
@Jacksonized
public class CreateTransactionRequest {

    String summary;
    TransactionCategoryType category;
    Long sum;
    String currency;
    ZonedDateTime paidAt;
}
