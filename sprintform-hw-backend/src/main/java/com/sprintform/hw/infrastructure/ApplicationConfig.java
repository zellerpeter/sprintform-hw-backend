package com.sprintform.hw.infrastructure;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import java.util.UUID;

/**
 * Configuration class.
 *
 * @author zellerpeter
 */
@Configuration
@ComponentScan(basePackages = "com.sprintform.hw")
@EnableJpaRepositories(basePackages = "com.sprintform.hw.application.repository")
@EntityScan("com.sprintform.hw.application.model.entity")
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorAware", dateTimeProviderRef = "utcDateTimeProvider")
public class ApplicationConfig {

    private static final UUID DEFAULT_UUID = new UUID(0, 0);

    @Bean
    public AuditorAware<UUID> auditorAware() {
        //TODO: temp uuid for createdBy, updatedBy
        return () -> Optional.of(DEFAULT_UUID);
    }

    @Bean
    public DateTimeProvider utcDateTimeProvider() {
        return () -> Optional.of(LocalDateTime.now(ZoneOffset.UTC));
    }

    @Bean
    @Primary
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            //builder.simpleDateFormat("yyyy.MM.dd HH:mm");

            builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        };
    }
}
