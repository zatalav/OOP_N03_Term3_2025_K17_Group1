package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.module.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SigninService {

    @Autowired
    private KhachHangAiven database;

    // Kiểm tra username đã tồn tại chưa
    public boolean isEmailExists(String email) {
        return database.selectByEmail(email) != null;
    }

    // Tạo mã khách hàng ngẫu nhiên
    public String generateCustomerCode() {
        String digits = "0123456789";
        StringBuilder code = new StringBuilder("KH_");
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            code.append(digits.charAt(random.nextInt(digits.length()))); // random số
        }

        return code.toString(); // Ví dụ: KHA_837
    }

    // Thêm khách hàng mới vào CSDL
    public void registerUser(String user, String password, String email) {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(generateCustomerCode()); // gán mã KH ngẫu nhiên
        kh.setUser(user);
        kh.setPassword(password);
        kh.setEmail(email);
        database.insert(kh);
    }
}
