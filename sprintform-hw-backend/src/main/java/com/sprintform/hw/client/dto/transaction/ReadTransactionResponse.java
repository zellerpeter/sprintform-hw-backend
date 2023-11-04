package com.sprintform.hw.client.dto.transaction;

import com.sprintform.hw.application.model.entity.transaction.TransactionCategoryType;
import com.sprintform.hw.client.dto.base.BaseReadResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;

/**
 * @author peti
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@SuperBuilder
@Getter
@Jacksonized
public class ReadTransactionResponse extends BaseReadResponse {

    String summary;
    TransactionCategoryType category;
    Long sum;
    String currency;
    ZonedDateTime paidAt;
}
