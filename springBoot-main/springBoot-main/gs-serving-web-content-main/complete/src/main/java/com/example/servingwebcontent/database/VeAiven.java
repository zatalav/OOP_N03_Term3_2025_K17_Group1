package com.example.servingwebcontent.database;

import com.example.servingwebcontent.Dao.Dao_interface;
import com.example.servingwebcontent.module.Ve;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class VeAiven implements Dao_interface<Ve> {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_exSUp-vLmtG417vPPN7@mysql-144ff22b-st-cdf0.c.aivencloud.com:24071/defaultdb?ssl-mode=REQUIRED",
                "avnadmin",
                "AVNS_exSUp-vLmtG417vPPN7");
    }

    @Override
    public int insert(Ve ve) {
        int kq = 0;
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO Ve (maVe, maChuyenBay, maKhachHang, ngayDatVe, ThoiGianBay, giaVe, giaVeVip, giaVeHangNhat, loaive) "
                    +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, ve.getMaVe());
                pst.setString(2, ve.getMaChuyenBay());
                pst.setString(3, ve.getMaKhachHang());
                pst.setDate(4, new java.sql.Date(ve.getNgayDatVe().getTime()));
                pst.setTime(5, Time.valueOf(ve.getThoiGianBay()));
                pst.setDouble(6, ve.getGiaVe());
                pst.setDouble(7, ve.getGiaVeVip());
                pst.setDouble(8, ve.getGiaVeHangNhat());
                pst.setString(9, ve.getLoaive());

                kq = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int update(Ve ve) {
        int kq = 0;
        try (Connection conn = getConnection()) {
            String sql = "UPDATE Ve SET maChuyenBay = ?, maKhachHang = ?, ngayDatVe = ?, ThoiGianBay = ?, giaVe = ?, giaVeVip = ?, giaVeHangNhat = ?, loaive = ? WHERE maVe = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, ve.getMaChuyenBay());
                pst.setString(2, ve.getMaKhachHang());
                pst.setDate(3, new java.sql.Date(ve.getNgayDatVe().getTime()));
                pst.setTime(4, Time.valueOf(ve.getThoiGianBay()));
                pst.setDouble(5, ve.getGiaVe());
                pst.setDouble(6, ve.getGiaVeVip());
                pst.setDouble(7, ve.getGiaVeHangNhat());
                pst.setString(8, ve.getLoaive());
                pst.setString(9, ve.getMaVe());

                kq = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int delete(String maVe) {
        int kq = 0;
        try (Connection conn = getConnection()) {
            String sql = "DELETE FROM Ve WHERE maVe = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, maVe);
                kq = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public ArrayList<Ve> selectAll() {
        ArrayList<Ve> kq = new ArrayList<>();
        try (Connection conn = getConnection();
                Statement st = conn.createStatement()) {
            String sql = "SELECT * FROM Ve";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Ve v = new Ve(
                        rs.getString("maVe"),
                        rs.getTimestamp("ngayDatVe"),
                        rs.getTime("ThoiGianBay").toLocalTime(),
                        rs.getDouble("giaVe"),
                        rs.getDouble("giaVeVip"),
                        rs.getDouble("giaVeHangNhat"),
                        rs.getString("loaive"),
                        rs.getString("maChuyenBay"),
                        rs.getString("maKhachHang"));
                kq.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public Ve selectById(String maVe) {
        Ve v = null;
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM Ve WHERE maVe = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, maVe);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    v = new Ve(
                            rs.getString("maVe"),
                            rs.getTimestamp("ngayDatVe"),
                            rs.getTime("ThoiGianBay").toLocalTime(),
                            rs.getDouble("giaVe"),
                            rs.getDouble("giaVeVip"),
                            rs.getDouble("giaVeHangNhat"),
                            rs.getString("loaive"),
                            rs.getString("maChuyenBay"),
                            rs.getString("maKhachHang"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    @Override
    public ArrayList<Ve> selectByCondition(String maVe) {
        ArrayList<Ve> list = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String sql = "SELECT v.*, cb.tenChuyenBay, cb.ngayGioKhoiHanh, cb.giaVe, cb.giaVeVip, cb.giaVeHangNhat, kh.hoTen, kh.email "
                    +
                    "FROM Ve v " +
                    "JOIN chuyenbay cb ON v.maChuyenBay = cb.maChuyenBay " +
                    "JOIN KhachHang kh ON v.maKhachHang = kh.maKhachHang " +
                    "WHERE v.maVe = ?";
            ;
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, maVe);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Ve ve = new Ve(
                            rs.getString("maVe"),
                            rs.getTimestamp("ngayDatVe"),
                            rs.getTime("ThoiGianBay").toLocalTime(),
                            rs.getDouble("giaVe"),
                            rs.getDouble("giaVeVip"),
                            rs.getDouble("giaVeHangNhat"),
                            rs.getString("loaive"),
                            rs.getString("maChuyenBay"),
                            rs.getString("maKhachHang"));
                    list.add(ve);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
