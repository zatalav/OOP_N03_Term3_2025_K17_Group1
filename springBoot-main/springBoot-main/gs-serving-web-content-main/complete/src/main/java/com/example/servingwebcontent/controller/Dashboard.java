package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dashboard {
    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "Admin/dashboard"; // Đúng tên thư mục và file (không cần .html)
    }
}