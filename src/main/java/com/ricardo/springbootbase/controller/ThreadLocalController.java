package com.ricardo.springbootbase.controller;

import com.ricardo.springbootbase.threadlocal.UserContent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadLocalController {

    @GetMapping("get")
    public String get() {
        return "Hello World";
    }

    @GetMapping("getInfo")
    public String getInfo() {
        return UserContent.get().getName();
    }
}
