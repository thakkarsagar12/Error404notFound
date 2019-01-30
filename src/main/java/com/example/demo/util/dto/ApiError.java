package com.example.demo.util.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiError {

    private int status;

    private String message;

    private String developerMessage;


    public ApiError(int status, String message, String developerMessage) {
        super();

        this.status = status;
        this.message = message;
        this.developerMessage = developerMessage;
    }
}
