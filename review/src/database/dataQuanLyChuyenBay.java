package src.database;

import src.model.ChuyenBay;
import java.util.ArrayList;
import src.dao.Dao_interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.data.JDBC;

public class dataQuanLyChuyenBay implements Dao_interface<ChuyenBay> {

    @Override
public int insert(ChuyenBay cb) {
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
        String sql = "INSERT INTO chuyenbay (maChuyenBay, tenChuyenBay, ngayGioKhoiHanh,ThoiGianBay, soLuongGhe, GheVip, GheHangNhat, GheThuong, diemKhoiHanh, diemDen, noiquoc) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, cb.getmaChuyenBay());
        ps.setString(2, cb.getTenChuyenBay());
        ps.setTimestamp(3, new java.sql.Timestamp(cb.getNgayGioKhoiHanh().getTime())); // Định dạng DATETIME
        ps.setInt(4,cb.getThoiGianBay());
        ps.setInt(5, cb.getSoLuongGhe());
        ps.setInt(6, cb.getGheVip());
        ps.setInt(7,cb.getGheHangNhat());
        ps.setInt(8,cb.getGheThuong());
        ps.setString(9, cb.getDiemKhoiHanh());
        ps.setString(10, cb.getDiemDen());
        ps.setString(11, cb.getNoiquoc());
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

    @Override
public int update(ChuyenBay cb) {
    int kq = 0;
    try {
        Connection con = JDBC.getConnection();
        String sql = "UPDATE chuyenbay SET tenChuyenBay=?, ngayGioKhoiHanh=?, ThoiGianBay=?, soLuongGhe=?, GheVip = ?, GheHangNhat = ?, GheThuong = ?, diemKhoiHanh=?, diemDen=?, noiquoc=? WHERE maChuyenBay=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cb.getTenChuyenBay());
        ps.setTimestamp(2, new java.sql.Timestamp(cb.getNgayGioKhoiHanh().getTime()));
        ps.setInt(3, cb.getThoiGianBay());
        ps.setInt(4, cb.getSoLuongGhe());
        ps.setInt(5, cb.getGheVip());
        ps.setInt(6, cb.getGheHangNhat());
        ps.setInt(7, cb.getGheThuong());
        ps.setString(8, cb.getDiemKhoiHanh());
        ps.setString(9, cb.getDiemDen());
        ps.setString(10, cb.getNoiquoc());
        ps.setString(11, cb.getmaChuyenBay());
        kq = ps.executeUpdate();
        ps.close();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return kq;
}

    @Override
    public int delete(ChuyenBay t) {
        int kq = 0;
        try {
             Connection con = JDBC.getConnection();

             Statement st = con.createStatement();

             String sql = "DELETE from chuyenbay " +  
             "Where maChuyenBay = '"+t.getmaChuyenBay()+"'" ;    
              kq = st.executeUpdate(sql);

             System.out.println("ban da thuc thi thanh cong cau lenh: " + sql);
             System.out.println("So dong thay doi: " + kq);

             JDBC.closeConnection(con);
            
        } catch (SQLException e) {
            // TODO: handle exception
        }

        return kq;
    }

    @Override
public ArrayList<ChuyenBay> selectAll() {
    ArrayList<ChuyenBay> kq = new ArrayList<ChuyenBay>();
    try {
        Connection con = JDBC.getConnection();
        Statement st = con.createStatement();
        String sql = "SELECT * FROM chuyenbay";  
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String maChuyenBay = rs.getString("maChuyenBay");
            String tenChuyenBay = rs.getString("tenChuyenBay");
            java.util.Date ngayGioKhoiHanh = rs.getTimestamp("ngayGioKhoiHanh");
            int ThoiGianBay = rs.getInt("ThoiGianBay");
            int soLuongGhe = rs.getInt("soLuongGhe");
            int GheVip = rs.getInt("GheVip");
            if (rs.wasNull()) {
                GheVip = soLuongGhe / 10; // Tính số ghế VIP nếu không có thông tin
            }
            int GheHangNhat = rs.getInt("GheHangNhat");
            if (rs.wasNull()) {
                GheHangNhat = soLuongGhe / 20;
            }
            int GheThuong = rs.getInt("GheThuong");
            if (rs.wasNull()) {
                 GheThuong = soLuongGhe - GheVip - GheHangNhat;
            }
            String diemKhoiHanh = rs.getString("diemKhoiHanh");
            String diemDen = rs.getString("diemDen");
            String noiquoc = rs.getString("noiquoc");

            ChuyenBay cb = new ChuyenBay(
                maChuyenBay, tenChuyenBay, ngayGioKhoiHanh,ThoiGianBay, soLuongGhe, GheVip, GheHangNhat, GheThuong, diemKhoiHanh, diemDen, noiquoc
            );
            kq.add(cb);
        }

        JDBC.closeConnection(con);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return kq;
}

    @Override
    public ChuyenBay selectById(ChuyenBay t) {
        Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ChuyenBay cb = null;

    try {
        con = JDBC.getConnection();
        String sql = "SELECT * FROM chuyenbay WHERE maChuyenBay = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, t.getmaChuyenBay());
        rs = ps.executeQuery();

        if (rs.next()) {
            cb = new ChuyenBay(
                rs.getString("maChuyenBay"),
                rs.getString("tenChuyenBay"),
                rs.getTimestamp("ngayGioKhoiHanh"),
                rs.getInt("ThoiGianBay"),
                rs.getInt("soLuongGhe"),
                rs.getInt("GheVip"),
                rs.getInt("GheHangNhat"),
                rs.getInt("GheThuong"),
                rs.getString("diemKhoiHanh"),
                rs.getString("diemDen"),
                rs.getString("noiquoc")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return cb;
    }

    @Override
public ArrayList<ChuyenBay> selectByCondition(String maChuyenBay) {
    ArrayList<ChuyenBay> kq = new ArrayList<>();
    try {
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM chuyenbay WHERE maChuyenBay = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, maChuyenBay);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ChuyenBay cb = new ChuyenBay(
                rs.getString("maChuyenBay"),
                rs.getString("tenChuyenBay"),
                rs.getTimestamp("ngayGioKhoiHanh"),
                rs.getInt("ThoiGianBay"),
                rs.getInt("soLuongGhe"),
                rs.getInt("GheVip"),
                rs.getInt("GheThuong"),
                rs.getInt("GheHangNhat"),
                rs.getString("diemKhoiHanh"),
                rs.getString("diemDen"),
                rs.getString("noiquoc")
            );
            kq.add(cb);
        }
        rs.close();
        ps.close();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return kq;
}
}