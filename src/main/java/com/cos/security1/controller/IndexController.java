package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//View 리턴하겠당
public class IndexController {

    // localhost:8080
    @GetMapping("/")
    public String index() {
        // Mustache 의 기본폴더 : src/main/resources/
        // View resorver 설정 : templates (prefix), mustache(suffix)생략가능!
        return "index";
    }
}
