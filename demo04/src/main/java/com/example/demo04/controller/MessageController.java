package com.example.demo04.controller;

import com.example.demo04.dto.CountyDTO;
import com.example.demo04.dto.GroupDTO;
import com.example.demo04.dto.StudentDTO;
import com.example.demo04.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@PropertySource(value="classpath:coustom.properties",encoding = "utf-8")
public class MessageController {
    @Resource
    private MessageService messageService;
    @Value("${city.name}")
    private String cityName;
    @Resource
    private StudentDTO studentDTO;
    @Resource
    private CountyDTO countyDTO;
    @Resource
    private GroupDTO groupDTO;
    @GetMapping("/getValue")
    public String getValue(){
        return cityName;
    }
    @GetMapping("/getDTOValue")
    public String getDTOValue(){
        return studentDTO.toString();
    }
     @GetMapping("/getListValue")
    public String getListValue(){
    return countyDTO.toString();
}
    @GetMapping("/getListObjecctValue")
    public String getListObjecctValue(){
    return groupDTO.toString();
    }

}
