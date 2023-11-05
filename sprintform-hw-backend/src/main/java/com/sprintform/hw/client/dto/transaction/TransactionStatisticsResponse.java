package com.sprintform.hw.client.dto.transaction;

import com.sprintform.hw.application.model.entity.transaction.TransactionCategoryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

/**
 * Aggregated statistics response.
 *
 * @author zellerpeter
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
