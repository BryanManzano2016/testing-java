package com.bmanzano.testingjava.services;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service @NoArgsConstructor
public class MathOperationsService {

    public int getSum(int num1, int num2) {
        return num1 + num2;
    }

    public Double getSum(Double num1, Double num2) {
        return num1 + num2;
    }
}
