package com.example.servingwebcontent.database;

import com.example.servingwebcontent.module.ThongKeDoanhThu;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ThongKeDoanhThuAiven {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_exSUp-vLmtG417vPPN7@mysql-144ff22b-st-cdf0.c.aivencloud.com:24071/defaultdb?ssl-mode=REQUIRED",
                "avnadmin",
                "AVNS_exSUp-vLmtG417vPPN7");
    }

    // ✅ Lấy danh sách thống kê doanh thu từ bảng VE theo tháng và năm
    public List<ThongKeDoanhThu> getThongKeTongTheoThangNam() {
        List<ThongKeDoanhThu> list = new ArrayList<>();
        String sql = """
                    SELECT
                        MONTH(ngayDatVe) AS thang,
                        YEAR(ngayDatVe) AS nam,
                        SUM(CASE
                            WHEN loaiVe LIKE '%thuong%' THEN giaVe
                            WHEN loaiVe LIKE '%vip%' THEN giaVeVip
                            WHEN loaiVe LIKE '%nhat%' THEN giaVeHangNhat
                            ELSE 0 END) AS tongTien
                    FROM Ve
                    GROUP BY thang, nam
                    ORDER BY nam DESC, thang DESC
                """;

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ThongKeDoanhThu tk = new ThongKeDoanhThu();
                tk.setThang(rs.getInt("thang"));
                tk.setNam(rs.getInt("nam"));
                tk.setTongTien(rs.getDouble("tongTien"));
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
