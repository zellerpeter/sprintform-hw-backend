package com.sprintform.hw.application.model.entity.base;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base entity that holds a unique identifier, and audit fields.
 * @author zellerpeter
 */
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@SuperBuilder(toBuilder = true)
@FieldNameConstants
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    /**
     * Unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    UUID id;

    /**
     * Create timestamp.
     */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    LocalDateTime createdAt;

    /**
     * Update timestamp.
     */
    @LastModifiedDate
    @Column(nullable = false)
    LocalDateTime updatedAt;

    /**
     * Create user.
     */
    @CreatedBy
    @Column(nullable = false, updatable = false)
    UUID createdBy;

    /**
     * Update user.
     */
    @LastModifiedBy
    @Column(nullable = false)
    UUID updatedBy;
}
