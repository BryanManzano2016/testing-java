package com.bmanzano.testingjava.beans;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class BodyOperation {
    Double numberA;
    Double numberB;
    Double result;
    String message;
}
