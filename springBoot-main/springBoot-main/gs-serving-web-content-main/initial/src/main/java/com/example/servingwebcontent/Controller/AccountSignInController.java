package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountSignInController {

    @Autowired
    private SigninService signinService;

    @GetMapping("/SignIn")
    public String showSignUpForm(Model model) {
        model.addAttribute("error", "");
        model.addAttribute("success", "");
        return "SignIn"; // Giao diện SignIn.html
    }

    @PostMapping("/SignIn")
    public String register(@RequestParam("user") String user,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {
        try {
            // Kiểm tra email trùng
            if (signinService.isEmailExists(email)) {
                model.addAttribute("error", "Email đã tồn tại!");
                return "SignIn";
            }

            // Kiểm tra mật khẩu
            if (password.length() < 6) {
                model.addAttribute("error", "Mật khẩu phải có ít nhất 6 ký tự!");
                return "SignIn";
            }

            // Gọi Service để thêm người dùng mới
            signinService.registerUser(user, password, email);

            model.addAttribute("success", "Đăng ký thành công! Mời bạn đăng nhập.");
            return "redirect:/login";

        } catch (Exception e) {
            e.printStackTrace(); // Ghi log
            model.addAttribute("error", "Đã xảy ra lỗi hệ thống, vui lòng thử lại.");
            return "SignIn";
        }
    }
}
