package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.database.adminAiven;
import com.example.servingwebcontent.module.adminLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminLoginService {

    @Autowired
    private adminAiven adminAiven;

    // ✅ Kiểm tra đăng nhập: đúng email + password thì trả về true
    public boolean checkLogin(String email, String password) {
        adminLogin admin = adminAiven.selectByEmailAndPassword(email, password);
        return admin != null;
    }

    // ✅ Trả về đối tượng admin nếu đăng nhập thành công
    public adminLogin getAdmin(String email, String password) {
        return adminAiven.selectByEmailAndPassword(email, password);
    }
}
