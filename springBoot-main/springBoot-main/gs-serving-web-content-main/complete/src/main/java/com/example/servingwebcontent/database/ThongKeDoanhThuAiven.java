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

    // ✅ Lấy danh sách thống kê theo tháng và năm
    public List<ThongKeDoanhThu> getThongKeTheoThangNam(int thang, int nam) {
        List<ThongKeDoanhThu> list = new ArrayList<>();

        try (Connection conn = getConnection()) {
            String sql = """
                        SELECT
                            id, maVe, ngayDatVe, giaVe, giaVeVip, giaVeHangNhat, loaive, thang, nam
                        FROM ThongKeDoanhThu
                        WHERE thang = ? AND nam = ?
                    """;

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, thang);
                ps.setInt(2, nam);

                ResultSet rs = ps.executeQuery();
                int count = 0;

                while (rs.next()) {
                    ThongKeDoanhThu tk = new ThongKeDoanhThu();
                    tk.setId(rs.getInt("id")); // ✅ Bổ sung dòng này
                    tk.setMaVe(rs.getString("maVe"));
                    tk.setNgayDatVe(rs.getDate("ngayDatVe"));
                    tk.setGiaVe(rs.getDouble("giaVe"));
                    tk.setGiaVeVip(rs.getDouble("giaVeVip"));
                    tk.setGiaVeHangNhat(rs.getDouble("giaVeHangNhat"));
                    tk.setLoaive(rs.getString("loaive"));
                    tk.setThang(rs.getInt("thang"));
                    tk.setNam(rs.getInt("nam"));

                    list.add(tk);
                    count++;

                    // 🟨 Log kiểm tra
                    System.out.println(">> [DEBUG] #" + tk.getId() + " | " + tk.getMaVe() + " | " + tk.getLoaive()
                            + " | " + tk.getGiaVe());
                }

                System.out.println(">> [DEBUG] Truy vấn thống kê: " + count + " kết quả.");
            }
        } catch (Exception e) {
            System.err.println(">> [ERROR] Lỗi khi truy vấn thống kê:");
            e.printStackTrace();
        }

        return list;
    }
}
