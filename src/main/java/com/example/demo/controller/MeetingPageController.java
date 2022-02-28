package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeetingPageController {
    @GetMapping("/")
    public String top() {
        return "test";
    }
}