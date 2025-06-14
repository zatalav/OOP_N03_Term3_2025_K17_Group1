package src.database;

import src.model.Ve;
import java.util.ArrayList;
import src.dao.Dao_interface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import src.data.JDBC;

public class dataQuanLyVe implements Dao_interface<Ve> {
    @Override
    public int insert(Ve t) {
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
            String sql = "INSERT INTO Ve (maVe, maChuyenBay, maKhachHang, ngayDatVe, giaVe) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaVe());
            ps.setString(2, t.getMaChuyenBay());
            ps.setString(3, t.getMaKhachHang());
            ps.setDate(4, new java.sql.Date(t.getNgayDatVe().getTime()));
            ps.setDouble(5, t.getGiaVe());
            kq = ps.executeUpdate();
            System.out.println("Đã chèn thành công " + kq + " dòng!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi chèn dữ liệu: " + e.getMessage());
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
    public int update(Ve t) {
        int kq = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBC.getConnection();
            if (con == null) {
                System.out.println("Khong the ket noi den MySQL!");
                return kq;
            }
            String sql = "UPDATE Ve SET maChuyenBay = ?, maKhachHang = ?, ngayDatVe = ?, giaVe = ? WHERE maVe = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaChuyenBay());
            ps.setString(2, t.getMaKhachHang());
            ps.setDate(3, (Date) t.getNgayDatVe());
            ps.setDouble(4, t.getGiaVe());
            ps.setString(5, t.getMaVe());
            kq = ps.executeUpdate();
            System.out.println("Đã cập nhật thành công " + kq + " dòng!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật dữ liệu: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return kq;
    }

    @Override
    public int delete(Ve t) {
        int kq = 0;
        try {
            Connection con = JDBC.getConnection();
            Statement st = con.createStatement();
            String sql = "DELETE from Ve WHERE maVe = '" + t.getMaVe() + "'";
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
    public ArrayList<Ve> selectAll() {
        ArrayList<Ve> kq = new ArrayList<Ve>();
        try {
            Connection con = JDBC.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Ve";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maVe = rs.getString("maVe");
                java.util.Date ngayDatVe = rs.getTimestamp("ngayDatVe");
                Double giaVe = rs.getDouble("giaVe");
                String maChuyenBay = rs.getString("maChuyenBay");
                String maKhachHang = rs.getString("maKhachHang");
                Ve v = new Ve(maVe, ngayDatVe, giaVe, maChuyenBay, maKhachHang);
                kq.add(v);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public Ve selectById(Ve t) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Ve v = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM Ve WHERE maVe = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaVe());
            rs = ps.executeQuery();
            if (rs.next()) {
                v = new Ve(
                        rs.getString("maVe"),
                        rs.getTimestamp("ngayDatVe"),
                        rs.getDouble("giaVe"),
                        rs.getString("maChuyenBay"),
                        rs.getString("maKhachHang"));
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
        return v;
    }

    @Override
    public ArrayList<Ve> selectByCondition(String maVe) {
        ArrayList<Ve> kq = new ArrayList<>();
        try {
            Connection con = JDBC.getConnection();
            String sql = "SELECT v.*, cb.tenChuyenBay, cb.ngayGioKhoiHanh, kh.hoTen, kh.email " +
                    "FROM Ve v " +
                    "JOIN chuyenbay cb ON v.maChuyenBay = cb.maChuyenBay " +
                    "JOIN KhachHang kh ON v.maKhachHang = kh.maKhachHang " +
                    "WHERE v.maVe = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maVe);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maVeResult = rs.getString("maVe");
                java.util.Date ngayDatVe = rs.getTimestamp("ngayDatVe");
                Double giaVe = rs.getDouble("giaVe");
                String maChuyenBay = rs.getString("maChuyenBay");
                String maKhachHang = rs.getString("maKhachHang");
                String tenChuyenBay = rs.getString("tenChuyenBay");
                java.util.Date ngayGioKhoiHanh = rs.getTimestamp("ngayGioKhoiHanh");
                String hoTenKhachHang = rs.getString("hoTen");
                String emailKhachHang = rs.getString("email");
                System.out.println("Mã vé: " + maVeResult);
                System.out.println("Mã chuyến bay: " + maChuyenBay + " - Tên chuyến bay: " + tenChuyenBay);
                System.out.println("Ngày giờ khởi hành: " + ngayGioKhoiHanh);
                System.out.println("Mã khách hàng: " + maKhachHang + " - Họ tên: " + hoTenKhachHang + " - Email: "
                        + emailKhachHang);
                System.out.println("Ngày đặt vé: " + ngayDatVe);
                System.out.println("Giá vé: " + giaVe);
                Ve ve = new Ve(maVeResult, ngayDatVe, giaVe, maChuyenBay, maKhachHang);
                kq.add(ve);
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
