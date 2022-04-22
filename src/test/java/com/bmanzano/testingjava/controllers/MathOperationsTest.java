package com.bmanzano.testingjava.controllers;

import com.bmanzano.testingjava.beans.BodyOperation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MathOperationsTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void mathOperationsSum() throws Exception {
        int numA = 2, numB = 3;
        this.mockMvc.perform(get(String.format("/math/sum/%d/%d", numA, numB)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(String.format("%d", numA + numB))));
    }

    @Test
    void mathOperationsSumJson() throws Exception {
        double numA = 2, numB = 3;
        this.mockMvc.perform(get("/math/sum/json/" + String.format("%f/%f", numA, numB))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).
                andExpect(jsonPath("$.result", is(numA + numB)));
    }

    @Test
    void mathOperationPost() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        BodyOperation value = BodyOperation.builder().numberA(2.0).numberB(5.0).build();
        mockMvc.perform(post("/math/sum")
                        .content(objectMapper.writeValueAsString(value))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(notNullValue())));
    }

}
