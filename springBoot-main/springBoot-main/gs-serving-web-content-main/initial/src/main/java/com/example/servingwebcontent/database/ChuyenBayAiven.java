package com.example.servingwebcontent.database;

import com.example.servingwebcontent.Dao.Dao_interface;
import com.example.servingwebcontent.module.ChuyenBay;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class ChuyenBayAiven implements Dao_interface<ChuyenBay> {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_exSUp-vLmtG417vPPN7@mysql-144ff22b-st-cdf0.c.aivencloud.com:24071/defaultdb?ssl-mode=REQUIRED",
                "avnadmin",
                "AVNS_exSUp-vLmtG417vPPN7");
    }

    @Override
    public int insert(ChuyenBay cb) {
        int rows = 0;
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO chuyenbay (maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, ThoiGianBay, giaVe, giaVeVip, giaVeHangNhat, soLuongGhe, GheVip, GheHangNhat, GheThuong, diemKhoiHanh, diemDen, noiquoc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cb.getMaChuyenBay());
                ps.setString(2, cb.getTenChuyenBay());
                ps.setTimestamp(3, new Timestamp(cb.getNgayGioKhoiHanh().getTime()));
                ps.setTime(4, Time.valueOf(cb.getThoiGianBay()));
                ps.setDouble(5, cb.getGiaVe());
                ps.setDouble(6, cb.getGiaVeVip());
                ps.setDouble(7, cb.getGiaVeHangNhat());
                ps.setInt(8, cb.getSoLuongGhe());
                ps.setInt(9, cb.getGheVip());
                ps.setInt(10, cb.getGheHangNhat());
                ps.setInt(11, cb.getGheThuong());
                ps.setString(12, cb.getDiemKhoiHanh());
                ps.setString(13, cb.getDiemDen());
                ps.setString(14, cb.getNoiQuoc());
                rows = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(ChuyenBay cb) {
        int rows = 0;
        try (Connection conn = getConnection()) {
            String sql = "UPDATE chuyenbay SET tenChuyenBay=?, ngayGioKhoiHanh=?, ThoiGianBay=?, giaVe=?, giaVeVip=?, giaVeHangNhat=?, soLuongGhe=?, GheVip=?, GheHangNhat=?, GheThuong=?, diemKhoiHanh=?, diemDen=?, noiquoc=? WHERE maChuyenBay=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cb.getTenChuyenBay());
                ps.setTimestamp(2, new Timestamp(cb.getNgayGioKhoiHanh().getTime()));
                ps.setTime(3, Time.valueOf(cb.getThoiGianBay()));
                ps.setDouble(4, cb.getGiaVe());
                ps.setDouble(5, cb.getGiaVeVip());
                ps.setDouble(6, cb.getGiaVeHangNhat());
                ps.setInt(7, cb.getSoLuongGhe());
                ps.setInt(8, cb.getGheVip());
                ps.setInt(9, cb.getGheHangNhat());
                ps.setInt(10, cb.getGheThuong());
                ps.setString(11, cb.getDiemKhoiHanh());
                ps.setString(12, cb.getDiemDen());
                ps.setString(13, cb.getNoiQuoc());
                ps.setString(14, cb.getMaChuyenBay());
                rows = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(String maChuyenBay) {
        int rows = 0;
        try (Connection conn = getConnection()) {
            String sql = "DELETE FROM chuyenbay WHERE maChuyenBay = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, maChuyenBay);
                rows = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public ArrayList<ChuyenBay> selectAll() {
        ArrayList<ChuyenBay> list = new ArrayList<>();
        try (Connection conn = getConnection(); Statement st = conn.createStatement()) {
            String sql = "SELECT * FROM chuyenbay";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ChuyenBay cb = new ChuyenBay(
                        rs.getString("maChuyenBay"),
                        rs.getString("tenChuyenBay"),
                        rs.getTimestamp("ngayGioKhoiHanh"),
                        rs.getTime("ThoiGianBay").toLocalTime(),
                        rs.getInt("soLuongGhe"),
                        rs.getInt("GheVip"),
                        rs.getInt("GheHangNhat"),
                        rs.getInt("GheThuong"),
                        rs.getString("diemKhoiHanh"),
                        rs.getString("diemDen"),
                        rs.getString("noiquoc"));
                cb.setGiaVe(rs.getDouble("giaVe"));
                cb.setGiaVeVip(rs.getDouble("giaVeVip"));
                cb.setGiaVeHangNhat(rs.getDouble("giaVeHangNhat"));
                list.add(cb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ChuyenBay selectById(String maChuyenBay) {
        ChuyenBay cb = null;
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM chuyenbay WHERE maChuyenBay = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, maChuyenBay);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    cb = new ChuyenBay(
                            rs.getString("maChuyenBay"),
                            rs.getString("tenChuyenBay"),
                            rs.getTimestamp("ngayGioKhoiHanh"),
                            rs.getTime("ThoiGianBay").toLocalTime(),
                            rs.getInt("soLuongGhe"),
                            rs.getInt("GheVip"),
                            rs.getInt("GheHangNhat"),
                            rs.getInt("GheThuong"),
                            rs.getString("diemKhoiHanh"),
                            rs.getString("diemDen"),
                            rs.getString("noiquoc"));
                    cb.setGiaVe(rs.getDouble("giaVe"));
                    cb.setGiaVeVip(rs.getDouble("giaVeVip"));
                    cb.setGiaVeHangNhat(rs.getDouble("giaVeHangNhat"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cb;
    }

    @Override
    public ArrayList<ChuyenBay> selectByCondition(String maChuyenBay) {
        ArrayList<ChuyenBay> list = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM chuyenbay WHERE maChuyenBay = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, maChuyenBay);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ChuyenBay cb = new ChuyenBay(
                            rs.getString("maChuyenBay"),
                            rs.getString("tenChuyenBay"),
                            rs.getTimestamp("ngayGioKhoiHanh"),
                            rs.getTime("ThoiGianBay").toLocalTime(),
                            rs.getInt("soLuongGhe"),
                            rs.getInt("GheVip"),
                            rs.getInt("GheHangNhat"),
                            rs.getInt("GheThuong"),
                            rs.getString("diemKhoiHanh"),
                            rs.getString("diemDen"),
                            rs.getString("noiquoc"));
                    cb.setGiaVe(rs.getDouble("giaVe"));
                    cb.setGiaVeVip(rs.getDouble("giaVeVip"));
                    cb.setGiaVeHangNhat(rs.getDouble("giaVeHangNhat"));
                    list.add(cb);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
