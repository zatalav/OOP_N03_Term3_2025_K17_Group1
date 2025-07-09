package com.example.servingwebcontent.database;

import com.example.servingwebcontent.module.accountLogin;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class accountAiven {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://avnadmin:AVNS_exSUp-vLmtG417vPPN7@mysql-144ff22b-st-cdf0.c.aivencloud.com:24071/defaultdb?ssl-mode=REQUIRED";
        String user = "avnadmin";
        String password = "AVNS_exSUp-vLmtG417vPPN7";
        return DriverManager.getConnection(url, user, password);
    }

    // ✅ Kiểm tra thông tin đăng nhập account từ bảng riêng, có thêm maVe
    public accountLogin selectByEmailAndPassword(String email, String password) {
        accountLogin account = null;
        try (Connection conn = getConnection()) {
            String sql = "SELECT email, password, maKhachHang FROM account WHERE email = ? AND password = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String maKhachHang = rs.getString("maKhachHang");
                    account = new accountLogin(email, password, maKhachHang);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }
}
