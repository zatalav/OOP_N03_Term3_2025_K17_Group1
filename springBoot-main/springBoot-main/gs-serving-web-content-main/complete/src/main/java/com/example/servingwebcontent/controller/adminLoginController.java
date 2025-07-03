package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Service.adminLoginService;
import com.example.servingwebcontent.module.adminLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class adminLoginController {

    @Autowired
    private adminLoginService adminLoginService;

    // ✅ Hiển thị form đăng nhập admin
    @GetMapping("/admin/adminLogin")
    public String showLoginForm(Model model) {
        model.addAttribute("adminLogin", new adminLogin());
        return "Admin/adminLogin"; // TÊN FILE HTML phải đúng
    }

    // ✅ Xử lý đăng nhập admin (POST)
    @PostMapping("/admin/adminLogin")
    public String processLogin(
            @ModelAttribute("adminLogin") adminLogin login,
            Model model) {
        boolean isValid = adminLoginService.checkLogin(login.getEmail(), login.getPassword());
        if (isValid) {
            model.addAttribute("message", "✅ Đăng nhập thành công.");
            return "Admin/dashboard"; // trỏ đúng view có thật
        } else {
            model.addAttribute("error", "❌ Sai email hoặc mật khẩu.");
            return "Admin/adminLogin"; // phải đúng file view
        }
    }
}
