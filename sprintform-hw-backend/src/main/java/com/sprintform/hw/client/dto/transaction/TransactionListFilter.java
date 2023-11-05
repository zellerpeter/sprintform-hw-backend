package com.sprintform.hw.client.dto.transaction;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;

/**
 * Filter conditions for transaction listing.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@Getter
@Jacksonized
public class TransactionListFilter {
    String summaryFilter;
    String categoryFilter;
    Long sumFrom;
    Long sumTo;
    String currencyFilter;
    ZonedDateTime paidAtFrom;
    ZonedDateTime paidAtTo;
}
