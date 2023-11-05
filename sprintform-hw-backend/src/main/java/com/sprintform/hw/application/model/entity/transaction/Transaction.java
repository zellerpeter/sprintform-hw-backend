package com.sprintform.hw.application.model.entity.transaction;

import com.sprintform.hw.application.model.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

/**
 * Entity for storing transaction data.
 * @author zellerpeter
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PRIVATE)
@Getter
@SuperBuilder(toBuilder = true)
@FieldNameConstants
@Entity
public class Transaction extends BaseEntity {

    @Column(nullable = false)
    String summary;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    TransactionCategoryType category;
    @Column(nullable = false)
    Long sum;
    @Column(nullable = false)
    String currency;
    @Column(nullable = false)
    ZonedDateTime paidAt;
}
