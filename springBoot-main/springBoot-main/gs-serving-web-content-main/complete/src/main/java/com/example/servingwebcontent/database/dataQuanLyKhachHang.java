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
        PreparedStatement ps = null;
        try {
            con = JDBC.getConnection();
            if (con == null) {
                System.out.println("Khong the ket noi den MySQL!");
                return kq;
            }
            con.setAutoCommit(true);
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
                if (ps != null)
                    ps.close();
                JDBC.closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return kq;
    }

    @Override
    public int delete(KhachHang t) {
        int kq = 0;
        try {
            Connection con = JDBC.getConnection();
            Statement st = con.createStatement();
            String sql = "DELETE from KhachHang " +
                    "Where maKhachHang = '" + t.getMaKhachHang() + "'";
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
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> kq = new ArrayList<>();
        try {
            Connection con = JDBC.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM KhachHang";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String hoTen = rs.getString("hoTen");
                String email = rs.getString("email");
                String soDienThoai = rs.getString("soDienThoai");
                String canCuocCongDan = rs.getString("canCuocCongDan");
                String diaChi = rs.getString("diachi");

                KhachHang kh = new KhachHang(
                        maKhachHang, hoTen, email, soDienThoai, canCuocCongDan, diaChi);
                kq.add(kh);
            }

            rs.close();
            st.close();
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int update(KhachHang t) {
        int kq = 0;
        try {
            Connection con = null;
            con = JDBC.getConnection();
            if (con == null) {
                System.out.println("Khong the ket noi den MySQL!");
                return kq;
            }
            con.setAutoCommit(true);
            String sql = "UPDATE KhachHang SET hoTen = ?, email = ?, soDienThoai = ?, canCuocCongDan = ?, diaChi = ? WHERE maKhachHang = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getHoTen());
            ps.setString(2, t.getEmail());
            ps.setString(3, t.getSoDienThoai());
            ps.setString(4, t.getCanCuocCongDan());
            ps.setString(5, t.getDiaChi());
            ps.setString(6, t.getMaKhachHang());

            kq = ps.executeUpdate();
            System.out.println("Da chen thanh cong " + kq + " dong!");
        } catch (SQLException e) {
            System.out.println("Loi khi chen du lieu: " + e.getMessage());
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public KhachHang selectById(KhachHang t) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        KhachHang kh = null;

        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM KhachHang WHERE maKhachHang = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaKhachHang());
            rs = ps.executeQuery();

            if (rs.next()) {
                kh = new KhachHang(
                        rs.getString("maKhachHang"),
                        rs.getString("hoTen"),
                        rs.getString("email"),
                        rs.getString("soDienThoai"),
                        rs.getString("canCuocCongDan"),
                        rs.getString("diachi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return kh;
    }

    @Override
    public ArrayList<KhachHang> selectByCondition(String maKhachHang) {
        ArrayList<KhachHang> kq = new ArrayList<>();
        try {
            Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM KhachHang WHERE maKhachHang = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maKhachHang);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhachHang kh = new KhachHang(
                        rs.getString("maKhachHang"),
                        rs.getString("hoTen"),
                        rs.getString("email"),
                        rs.getString("soDienThoai"),
                        rs.getString("canCuocCongDan"),
                        rs.getString("diachi"));
                kq.add(kh);
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
