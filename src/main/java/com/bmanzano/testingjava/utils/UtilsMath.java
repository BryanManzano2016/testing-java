package com.bmanzano.testingjava.utils;

public class UtilsMath {
    public static boolean isImposibleDivision(Integer numA, Integer numB) {
        return numA == null || numB == null || numB == 0;
    }
}
