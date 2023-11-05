package com.sprintform.hw.client.dto.transaction;

import com.sprintform.hw.application.model.entity.transaction.TransactionCategoryType;
import com.sprintform.hw.client.dto.base.BaseUpdateRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;

/**
 * Update request for transactions.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@SuperBuilder
@Getter
@Jacksonized
public class UpdateTransactionRequest extends BaseUpdateRequest {

    @NotNull
    String summary;
    @NotNull
    TransactionCategoryType category;
    @NotNull
    Long sum;
    @NotNull
    String currency;
    @NotNull
    ZonedDateTime paidAt;
}
