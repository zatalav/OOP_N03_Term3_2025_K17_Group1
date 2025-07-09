package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.database.accountAiven;
import com.example.servingwebcontent.module.accountLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class accountLoginService {

    @Autowired
    private accountAiven accountAiven;

    // ✅ Kiểm tra đăng nhập: đúng email + password thì trả về true
    public boolean checkLogin(String email, String password) {
        accountLogin account = accountAiven.selectByEmailAndPassword(email, password);
        return account != null;
    }

    // ✅ Trả về đối tượng account nếu đăng nhập thành công
    public accountLogin getaccount(String email, String password) {
        return accountAiven.selectByEmailAndPassword(email, password);
    }
}
