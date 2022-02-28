package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailPageController {
    @GetMapping("/Inquiry/inquiry")
    String inquiry(Model model) {
        return "Inquiry/inquiry";
    }
}