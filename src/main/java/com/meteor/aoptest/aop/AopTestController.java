package com.meteor.aoptest.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/api")
@RestController
public class AopTestController {

    @GetMapping("/aop")
    public String hello() {
        return "Hello World";
    }

}
