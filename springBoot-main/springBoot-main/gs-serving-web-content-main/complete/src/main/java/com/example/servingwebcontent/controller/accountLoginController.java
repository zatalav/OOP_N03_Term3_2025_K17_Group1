package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Service.accountLoginService;
import com.example.servingwebcontent.module.accountLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class accountLoginController {

    @Autowired
    private accountLoginService accountLoginService;

    // Hiển thị form đăng nhập account
    @GetMapping("/admin/accountLogin")
    public String showLoginForm(Model model) {
        model.addAttribute("accountLogin", new accountLogin());
        return "Admin/accountLogin";
    }

    // Xử lý đăng nhập account (POST)
    @PostMapping("/admin/accountLogin")
    public String processLogin(
            @ModelAttribute("accountLogin") accountLogin login,
            Model model) {
        boolean isValid = accountLoginService.checkLogin(login.getEmail(), login.getPassword());
        if (isValid) {
            model.addAttribute("message", "✅ Đăng nhập thành công.");
            return "Admin/dashboard";
        } else {
            model.addAttribute("error", "❌ Sai email hoặc mật khẩu.");
            return "Admin/accountLogin";
        }
    }
}
