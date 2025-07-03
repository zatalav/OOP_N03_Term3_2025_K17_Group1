package com.example.servingwebcontent.database;

import com.example.servingwebcontent.module.adminLogin;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class adminAiven {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://avnadmin:AVNS_exSUp-vLmtG417vPPN7@mysql-144ff22b-st-cdf0.c.aivencloud.com:24071/defaultdb?ssl-mode=REQUIRED";
        String user = "avnadmin";
        String password = "AVNS_exSUp-vLmtG417vPPN7";
        return DriverManager.getConnection(url, user, password);
    }

    // ✅ Kiểm tra thông tin đăng nhập admin từ bảng riêng
    public adminLogin selectByEmailAndPassword(String email, String password) {
        adminLogin admin = null;
        try (Connection conn = getConnection()) {
            String sql = "SELECT email, password FROM admin WHERE email = ? AND password = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    admin = new adminLogin(rs.getString("email"), rs.getString("password"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }
}
