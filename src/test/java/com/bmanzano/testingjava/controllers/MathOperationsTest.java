package com.bmanzano.testingjava.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}
