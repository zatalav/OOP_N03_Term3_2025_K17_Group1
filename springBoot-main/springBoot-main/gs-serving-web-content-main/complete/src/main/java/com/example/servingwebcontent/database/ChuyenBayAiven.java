package com.example.servingwebcontent.database;

import com.example.servingwebcontent.Dao.Dao_interface;
import com.example.servingwebcontent.module.ChuyenBay;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class ChuyenBayAiven implements Dao_interface<ChuyenBay> {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://avnadmin:AVNS_exSUp-vLmtG417vPPN7@mysql-144ff22b-st-cdf0.c.aivencloud.com:24071/defaultdb?ssl-mode=REQUIRED";
        String user = "avnadmin";
        String password = "AVNS_exSUp-vLmtG417vPPN7";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public int insert(ChuyenBay cb) {
        String sql = "INSERT INTO chuyenbay (maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, ThoiGianBay, giaVe, giaVeVip, giaVeHangNhat, soLuongGhe, GheVip, GheHangNhat, GheThuong, diemKhoiHanh, diemDen, noiquoc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cb.getMaChuyenBay());
            ps.setString(2, cb.getTenChuyenBay());
            ps.setTimestamp(3, Timestamp.valueOf(cb.getNgayGioKhoiHanh()));
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
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(ChuyenBay cb) {
        String sql = "UPDATE chuyenbay SET tenChuyenBay=?, ngayGioKhoiHanh=?, ThoiGianBay=?, giaVe=?, giaVeVip=?, giaVeHangNhat=?, soLuongGhe=?, GheVip=?, GheHangNhat=?, GheThuong=?, diemKhoiHanh=?, diemDen=?, noiquoc=? WHERE maChuyenBay=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cb.getTenChuyenBay());
            ps.setTimestamp(2, Timestamp.valueOf(cb.getNgayGioKhoiHanh()));
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
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(String maChuyenBay) {
        String sql = "DELETE FROM chuyenbay WHERE maChuyenBay = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maChuyenBay);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<ChuyenBay> selectAll() {
        ArrayList<ChuyenBay> list = new ArrayList<>();
        String sql = "SELECT * FROM chuyenbay";
        try (Connection conn = getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapResultSetToChuyenBay(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ChuyenBay selectById(String maChuyenBay) {
        String sql = "SELECT * FROM chuyenbay WHERE maChuyenBay = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maChuyenBay);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToChuyenBay(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ChuyenBay> selectByCondition(String maChuyenBay) {
        ArrayList<ChuyenBay> list = new ArrayList<>();
        String sql = "SELECT * FROM chuyenbay WHERE maChuyenBay = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maChuyenBay);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToChuyenBay(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private ChuyenBay mapResultSetToChuyenBay(ResultSet rs) throws SQLException {
        ChuyenBay cb = new ChuyenBay(
                rs.getString("maChuyenBay"),
                rs.getString("tenChuyenBay"),
                rs.getTimestamp("ngayGioKhoiHanh").toLocalDateTime(),
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
        return cb;
    }
}