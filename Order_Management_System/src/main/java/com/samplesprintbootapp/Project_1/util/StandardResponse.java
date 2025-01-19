package com.samplesprintbootapp.Project_1.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
