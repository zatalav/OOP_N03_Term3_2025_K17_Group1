package src.database;

import src.model.KhachHang;
import java.util.ArrayList;
import src.dao.Dao_interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import src.data.JDBC;

public class dataQuanLyKhachHang implements Dao_interface<KhachHang> {
    @Override
    public int insert(KhachHang t) {
        int kq = 0;
    Connection con = null;
    PreparedStatement ps = null; // Sử dụng PreparedStatement để an toàn hơn
    try {
        con = JDBC.getConnection();
        if (con == null) {
            System.out.println("Khong the ket noi den MySQL!");
            return kq;
        }
        con.setAutoCommit(true); // Bật autocommit
        String sql = "INSERT INTO KhachHang (maKhachHang, hoTen,email, soDienThoai, canCuocCongDan, diaChi) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, t.getMaKhachHang());
        ps.setString(2, t.getHoTen());
        ps.setString(3, t.getEmail());
        ps.setString(4, t.getSoDienThoai());
        ps.setString(5, t.getCanCuocCongDan());
        ps.setString(6, t.getDiaChi());
        kq = ps.executeUpdate();
        System.out.println("Da chen thanh cong " + kq + " dong!");
    } catch (SQLException e) {
        System.out.println("Loi khi chen du lieu: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return kq;
    }
}