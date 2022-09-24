package com.example.api.controller;

import com.niu.model.TestModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {




    @GetMapping("/1")
    public TestModel test长度长一些再(@RequestParam("a") String a){
        MDC.put("traceId", a);

        log.info("一个请求进来{}",a);

        MDC.clear();
        return new TestModel(1,"niu");
    }

}
