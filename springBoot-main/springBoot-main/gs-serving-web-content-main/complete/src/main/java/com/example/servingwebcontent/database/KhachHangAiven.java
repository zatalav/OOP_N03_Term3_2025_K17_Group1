package com.example.servingwebcontent.database;

import com.example.servingwebcontent.Dao.Dao_interface;
import com.example.servingwebcontent.module.KhachHang;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class KhachHangAiven implements Dao_interface<KhachHang> {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_exSUp-vLmtG417vPPN7@mysql-144ff22b-st-cdf0.c.aivencloud.com:24071/defaultdb?ssl-mode=REQUIRED",
                "avnadmin",
                "AVNS_exSUp-vLmtG417vPPN7");
    }

    @Override
    public int insert(KhachHang kh) {
        int rows = 0;
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO KhachHang (maKhachHang, user, password, hoTen, email, soDienThoai, canCuocCongDan, diaChi, city, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, kh.getMaKhachHang());
                ps.setString(2, kh.getUser());
                ps.setString(3, kh.getPassword());
                ps.setString(4, kh.getHoTen());
                ps.setString(5, kh.getEmail());
                ps.setString(6, kh.getSoDienThoai());
                ps.setString(7, kh.getCanCuocCongDan());
                ps.setString(8, kh.getDiaChi());
                ps.setString(9, kh.getCity());
                ps.setString(10, kh.getCountry());
                rows = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(KhachHang kh) {
        int rows = 0;
        try (Connection conn = getConnection()) {
            String sql = "UPDATE KhachHang SET user=?, password=?, hoTen=?, email=?, soDienThoai=?, canCuocCongDan=?, diaChi=?, city=?, country=? WHERE maKhachHang=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, kh.getUser());
                ps.setString(2, kh.getPassword());
                ps.setString(3, kh.getHoTen());
                ps.setString(4, kh.getEmail());
                ps.setString(5, kh.getSoDienThoai());
                ps.setString(6, kh.getCanCuocCongDan());
                ps.setString(7, kh.getDiaChi());
                ps.setString(8, kh.getCity());
                ps.setString(9, kh.getCountry());
                ps.setString(10, kh.getMaKhachHang());
                rows = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(String maKh) {
        int rows = 0;
        try (Connection conn = getConnection()) {
            String sql = "DELETE FROM KhachHang WHERE maKhachHang = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, maKh);
                rows = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> list = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM KhachHang";
            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    KhachHang kh = new KhachHang(
                            rs.getString("maKhachHang"),
                            rs.getString("user"),
                            rs.getString("password"),
                            rs.getString("hoTen"),
                            rs.getString("email"),
                            rs.getString("soDienThoai"),
                            rs.getString("canCuocCongDan"),
                            rs.getString("diaChi"),
                            rs.getString("city"),
                            rs.getString("country"));
                    list.add(kh);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public KhachHang selectById(String maKhachHang) {
        KhachHang kh = null;
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM KhachHang WHERE maKhachHang = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, maKhachHang);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    kh = new KhachHang(
                            rs.getString("maKhachHang"),
                            rs.getString("user"),
                            rs.getString("password"),
                            rs.getString("hoTen"),
                            rs.getString("email"),
                            rs.getString("soDienThoai"),
                            rs.getString("canCuocCongDan"),
                            rs.getString("diaChi"),
                            rs.getString("city"),
                            rs.getString("country"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    @Override
    public ArrayList<KhachHang> selectByCondition(String maKhachHang) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM KhachHang WHERE maKhachHang = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, maKhachHang);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    KhachHang kh = new KhachHang(
                            rs.getString("maKhachHang"),
                            rs.getString("user"),
                            rs.getString("password"),
                            rs.getString("hoTen"),
                            rs.getString("email"),
                            rs.getString("soDienThoai"),
                            rs.getString("canCuocCongDan"),
                            rs.getString("diaChi"),
                            rs.getString("city"),
                            rs.getString("country"));
                    list.add(kh);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhachHang selectByUserAndPassword(String username, String password) {
        KhachHang kh = null;
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM KhachHang WHERE user = ? AND password = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    kh = new KhachHang(
                            rs.getString("maKhachHang"),
                            rs.getString("user"),
                            rs.getString("password"),
                            rs.getString("hoTen"),
                            rs.getString("email"),
                            rs.getString("soDienThoai"),
                            rs.getString("canCuocCongDan"),
                            rs.getString("diaChi"),
                            rs.getString("city"),
                            rs.getString("country"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    public KhachHang selectByEmail(String email) {
        KhachHang kh = null;
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM KhachHang WHERE email = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    kh = new KhachHang(
                            rs.getString("maKhachHang"),
                            rs.getString("user"),
                            rs.getString("password"),
                            rs.getString("hoTen"),
                            rs.getString("email"),
                            rs.getString("soDienThoai"),
                            rs.getString("canCuocCongDan"),
                            rs.getString("diaChi"),
                            rs.getString("city"),
                            rs.getString("country"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }
}
