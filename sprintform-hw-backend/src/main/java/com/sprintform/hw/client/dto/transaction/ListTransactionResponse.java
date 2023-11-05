package com.sprintform.hw.client.dto.transaction;

import com.sprintform.hw.application.model.entity.transaction.TransactionCategoryType;
import com.sprintform.hw.client.dto.base.BaseListResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;

/**
 * List response for transactions.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@SuperBuilder
@Getter
@Jacksonized
public class ListTransactionResponse extends BaseListResponse {

    String summary;
    TransactionCategoryType category;
    Long sum;
    String currency;
    ZonedDateTime paidAt;
}
