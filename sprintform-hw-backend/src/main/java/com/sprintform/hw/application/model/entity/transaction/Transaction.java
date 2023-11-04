package com.sprintform.hw.application.model.entity.transaction;

import com.sprintform.hw.application.model.entity.base.BaseEntity;
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
 * @author peti
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PRIVATE)
@Getter
@SuperBuilder(toBuilder = true)
@FieldNameConstants
@Entity
public class Transaction extends BaseEntity {

    String summary;
    @Enumerated(EnumType.STRING)
    TransactionCategoryType category;
    Long sum;
    String currency;
    ZonedDateTime paidAt;
}
