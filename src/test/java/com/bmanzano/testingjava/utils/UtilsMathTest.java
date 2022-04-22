package com.bmanzano.testingjava.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UtilsMathTest {

    @Test
    void testDivision() {
        Assertions.assertTrue(UtilsMath.isImposibleDivision(2, 0));
    }
}
