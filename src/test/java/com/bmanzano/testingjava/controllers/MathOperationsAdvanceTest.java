package com.bmanzano.testingjava.controllers;

import com.bmanzano.testingjava.services.MathOperationsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MathOperations.class)
class MathOperationsAdvanceTest {
    @Autowired
    private MockMvc mockMvcAdvance;

    @MockBean
    private MathOperationsService serviceAdvance;

    @Test
    void mathOperationsSumAdvance() throws Exception {
        int numA = 2, numB = 20;

        when(serviceAdvance.getSum(numA, numB)).thenReturn(numA + numB);

        this.mockMvcAdvance.perform(get(String.format("/math/sum/%d/%d", numA, numB)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(String.format("%d", numA + numB))));
    }
}
