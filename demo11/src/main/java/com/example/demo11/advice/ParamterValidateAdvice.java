package com.example.demo11.advice;

import com.example.demo11.exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

//验证失败返回验证信息+400
//当前类为通知（切面）
@ControllerAdvice
public class ParamterValidateAdvice {

    @ExceptionHandler
    public ResponseEntity<String> validateHandle(StudentException studentException){
        String mes = studentException.getMessage()+"{"+ studentException.getErrField()+":"+ studentException.getErrValue()+"}";
        return  new ResponseEntity<>(mes, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<String> validateHandle(WebExchangeBindException webExchangeBindException){
        return  new ResponseEntity<>(exToStr(webExchangeBindException), HttpStatus.BAD_REQUEST);
    }

    private String exToStr(WebExchangeBindException webExchangeBindException){
        return webExchangeBindException.getFieldErrors().stream().map(e->e.getField()+":"+e.getDefaultMessage()).reduce("",(s1,s2)->s1+"---"+s2);
    }
}
