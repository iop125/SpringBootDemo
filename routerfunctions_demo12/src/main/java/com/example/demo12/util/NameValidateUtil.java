package com.example.demo12.util;


import com.example.demo12.exception.StudentException;

import java.util.stream.Stream;

/**
 * company: www.kaikeba.com
 * Author: Rey
 */
public class NameValidateUtil {
    // 无效姓名列表
    private static final String[] INVALIDE_NAMES = {"admin", "administrator", "xxx", "ooo"};

    public static void validateName(String name) {
        Stream.of(INVALIDE_NAMES)
                .filter(invalideName -> name.equalsIgnoreCase(invalideName))
                .findAny()
                .ifPresent(invalideName -> {
                    throw new StudentException("name", invalideName, "使用了非法姓名");
                });
    }
}
