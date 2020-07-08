package com.example.demo06.dao;

import com.example.demo06.demain.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao {
    @Insert("INSERT INTO userinfo(userName, passWord) VALUES (#{userName}, #{passWord})")
    void insertEmployee(Employee employee);

}
