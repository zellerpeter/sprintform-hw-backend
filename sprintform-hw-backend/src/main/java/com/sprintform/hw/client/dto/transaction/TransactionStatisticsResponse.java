package com.sprintform.hw.client.dto.transaction;

import com.sprintform.hw.application.model.entity.transaction.TransactionCategoryType;
import com.sprintform.hw.client.dto.base.BaseReadResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;

/**
 * Aggregated statistics response.
 * @author peti
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Getter
@Jacksonized
public class TransactionStatisticsResponse {

    /**
     * Category (base of the aggregation).
     */
    TransactionCategoryType category;

    /**
     * Sum of sums.
     */
    Long sum;

    /**
     * Number of elements.
     */
    Long count;
}
