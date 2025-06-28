package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.module.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private KhachHangAiven database;

    // Kiểm tra user đã tồn tại chưa (dùng cho đăng ký tài khoản)
    public boolean isEmailExists(String email) {
        return database.selectByEmail(email) != null;
    }

    // Thêm khách hàng mới
    public void add(KhachHang login) {
        database.insert(login);
    }

    // Kiểm tra đăng nhập
    public boolean checkLogin(String email, String password) {
        return database.selectByUserAndPassword(email, password) != null;
    }

    // Trả về đối tượng KhachHang nếu đăng nhập thành công
    public KhachHang getKhachHang(String email, String password) {
        return database.selectByUserAndPassword(email, password);
    }
}
