package com.sprintform.hw.client.dto.transaction;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

/**
 * Filter conditions for aggregated statistics.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@Getter
@Jacksonized
public class TransactionStatisticsFilter {
    String category;
}
