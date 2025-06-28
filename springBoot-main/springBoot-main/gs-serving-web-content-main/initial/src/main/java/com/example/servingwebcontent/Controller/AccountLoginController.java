package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Service.LoginService;
import com.example.servingwebcontent.module.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountLoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Trả về trang login.html
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {

        // Gọi service để kiểm tra thông tin đăng nhập
        KhachHang khachHang = loginService.getKhachHang(email, password);

        if (khachHang != null) {
            // Đăng nhập thành công → lưu đối tượng KhachHang vào session
            session.setAttribute("currentUser", khachHang);
            return "redirect:/khachhang"; // Chuyển hướng đến trang chủ
        } else {
            // Sai thông tin → trả lại trang login với thông báo lỗi
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            return "login";
        }
    }
}
