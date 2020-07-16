package com.example.demo11.bean;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseEntity<T> {
    private HttpStatus code;
    private T data;

    public ResponseEntity(HttpStatus code) {
        this.code = code;
//        this.data = date;
    }
}
