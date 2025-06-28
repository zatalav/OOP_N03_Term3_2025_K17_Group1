package com.example.servingwebcontent.database;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class ThongKeDoanhThuAiven {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_exSUp-vLmtG417vPPN7@mysql-144ff22b-st-cdf0.c.aivencloud.com:24071/defaultdb?ssl-mode=REQUIRED",
                "avnadmin",
                "AVNS_exSUp-vLmtG417vPPN7");
    }

    public double getDoanhThuTheoThangNam(int thang, int nam) {
        double doanhThu = 0;
        try (Connection conn = getConnection()) {
            String sql = "SELECT SUM(CASE loaive " +
                    "WHEN 'Thuong' THEN giaVe " +
                    "WHEN 'Vip' THEN giaVeVip " +
                    "WHEN 'HangNhat' THEN giaVeHangNhat " +
                    "END) AS tongDoanhThu " +
                    "FROM Ve WHERE MONTH(ngayDatVe) = ? AND YEAR(ngayDatVe) = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, thang);
                ps.setInt(2, nam);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    doanhThu = rs.getDouble("tongDoanhThu");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doanhThu;
    }
}
