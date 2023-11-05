package com.sprintform.hw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprintform.hw.application.model.entity.transaction.TransactionCategoryType;
import com.sprintform.hw.client.dto.transaction.CreateTransactionRequest;
import com.sprintform.hw.client.dto.transaction.ReadTransactionResponse;
import com.sprintform.hw.infrastructure.ApplicationConfig;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for transaction API.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@SpringBootTest(classes = ApplicationConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TransactionControllerTests {

    MockMvc mockMvc;

    ObjectMapper objectMapper;

    @Test
    void simpleCreateTest() throws Exception {
        final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        final CreateTransactionRequest request = CreateTransactionRequest.builder()
                .summary("alberlet")
                .category(TransactionCategoryType.HOUSING)
                .sum(150000L)
                .currency("HUF")
                .paidAt(now)
                .build();

        final MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/transaction")
                        .content(asJsonString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        final ReadTransactionResponse response = objectMapper.readValue(result.getResponse().getContentAsString(),
                ReadTransactionResponse.class);

        final ReadTransactionResponse expected = ReadTransactionResponse.builder()
                .id(response.getId())
                .createdAt(response.getCreatedAt())
                .summary("alberlet")
                .category(TransactionCategoryType.HOUSING)
                .sum(150000L)
                .currency("HUF")
                .paidAt(now)
                .build();

        JSONAssert.assertEquals(asJsonString(expected), asJsonString(response), false);
    }

    private String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
