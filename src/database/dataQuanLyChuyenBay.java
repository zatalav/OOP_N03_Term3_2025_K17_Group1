package src.database;

import src.model.ChuyenBay;
import java.util.ArrayList;
import src.dao.Dao_interface;
import src.data.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dataQuanLyChuyenBay implements Dao_interface<ChuyenBay> {

    @Override
public int insert(ChuyenBay t) {
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
        String sql = "INSERT INTO chuyenbay (maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, soLuongGhe, diemKhoiHanh, diemDen, noiquoc) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, t.getMaChuyenBay());
        ps.setString(2, t.getTenChuyenBay());
        ps.setTimestamp(3, new java.sql.Timestamp(t.getNgayGioKhoiHanh().getTime())); // Định dạng DATETIME
        ps.setInt(4, t.getSoLuongGhe());
        ps.setString(5, t.getDiemKhoiHanh());
        ps.setString(6, t.getDiemDen());
        ps.setString(7, t.getNoiquoc());
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
    public int update(ChuyenBay t) {
       int kq = 0;
        try {
             Connection con = JDBC.getConnection();

             Statement st = con.createStatement();

             String sql = "UPDATE chuyenbay " + 
             " SET "+
             "tenChuyenBay = '"+t.getTenChuyenBay()+"', "+
             "ngayGioKhoiHanh = '"+t.getNgayGioKhoiHanh()+"', "+
             "soLuongGhe = "+t.getSoLuongGhe()+ ", "+
             "diemKhoiHanh = '"+t.getDiemKhoiHanh()+"', "+
             "DiemDen = '"+t.getDiemDen()+"' " +    
             "Where maChuyenBay = '"+t.getMaChuyenBay()+"'" ;    
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
    public int delete(ChuyenBay t) {
        int kq = 0;
        try {
             Connection con = JDBC.getConnection();

             Statement st = con.createStatement();

             String sql = "DELETE from chuyenbay " +  
             "Where maChuyenBay = '"+t.getMaChuyenBay()+"'" ;    
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
            int soLuongGhe = rs.getInt("soLuongGhe");
            String diemKhoiHanh = rs.getString("diemKhoiHanh");
            String diemDen = rs.getString("diemDen");
            String noiquoc = rs.getString("noiquoc");

            ChuyenBay cb = new ChuyenBay(
                maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, soLuongGhe, diemKhoiHanh, diemDen, noiquoc
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public Arraylist<ChuyenBay> selectByCondition(String condition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByCondition'");
    }

}