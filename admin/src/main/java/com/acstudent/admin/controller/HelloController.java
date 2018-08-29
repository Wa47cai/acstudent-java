package com.acstudent.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Siqi
 * @date 2018/8/29
 */
@Slf4j
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        log.info("hello");
        return "hello acstudent";
    }

}
