package com.example.demo11.util;


import com.example.demo11.exception.StudentException;

import java.util.stream.Stream;

public class NameValitdateUtil {
    private static final String[] arr = {};

    public static void validateName(String name){
        Stream.of(arr).filter(arrName->name.equalsIgnoreCase(arrName)).findAny().ifPresent(arrName->{throw new StudentException(arrName,"","");});
    }
}
