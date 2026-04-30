package com.example.log.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Log4jDemoController {
    private static final Logger log = LogManager.getLogger(Log4jDemoController.class);

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        log.info("Hello endpoint called with name={}", name);
        return "Hello, " + name;
    }
}
