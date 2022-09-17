package com.example.api.controller;

import com.niu.model.TestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {




    @GetMapping("/1")
    public TestModel test1(){
        return new TestModel(1,"niu");
    }
}
