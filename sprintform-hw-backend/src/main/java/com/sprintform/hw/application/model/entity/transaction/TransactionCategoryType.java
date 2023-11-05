package com.sprintform.hw.application.model.entity.transaction;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

/**
 * Possible values for category.
 * @author zellerpeter
 */
public enum TransactionCategoryType {
    HOUSING,
    TRAVEL,
    FOOD,
    UTILITIES,
    INSURANCE,
    HEALTHCARE,
    FINANCIAL,
    LIFESTYLE,
    ENTERTAINMENT,
    MISCELLANEOUS;

    @JsonCreator
    public static TransactionCategoryType of(final String category) {
        return Arrays.stream(values())
                .filter(transactionCategoryType -> category.equals(transactionCategoryType.name()))
                .findFirst()
                .orElse(null);
    }
}
