package com.example.demo06.controller;


import com.example.demo06.dao.EmployeeDao;
import com.example.demo06.demain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class MessageController {
    @Resource
    private EmployeeDao employeeDao;

    @GetMapping("/addMeesage")
    public String getJsp() {
        Employee e = new Employee("11111", "0000");
        employeeDao.insertEmployee(e);
        return "we";
    }

}
