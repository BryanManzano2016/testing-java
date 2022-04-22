package com.bmanzano.testingjava.controllers;

import com.bmanzano.testingjava.beans.BodyOperation;
import com.bmanzano.testingjava.services.MathOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("math")
public class MathOperations {
    @Autowired
    MathOperationsService mathOperationsService;

    @GetMapping("/test")
    public Integer test() {
        return Integer.bitCount(0);
    }

    @GetMapping("/sum/{num1}/{num2}")
    public int sum(@PathVariable int num1, @PathVariable int num2) {
        return mathOperationsService.getSum(num1, num2);
    }

    @GetMapping("/sum/json/{num1}/{num2}")
    public BodyOperation sumJson(@PathVariable Double num1, @PathVariable Double num2) {
        Double result = mathOperationsService.getSum(num1, num2);
        return BodyOperation.builder().
                numberA(num1).numberB(num2).result(result).
                message(String.format("The result is %f", result)).
                build();
    }
}
