package src.database;

import src.model.Ve;
import java.util.ArrayList;
import src.dao.Dao_interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import src.data.JDBC;

public class dataQuanLyVe implements Dao_interface<Ve> {
   @Override
    public int insert(Ve t) {
        double giaVeVip = t.getGiaVe() * 1.5;
        double giaVeHangNhat =t.getGiaVe() * 3;
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
            String sql = "INSERT INTO Ve (maVe, maChuyenBay, maKhachHang, ngayDatVe,ThoiGianBay, giaVe, giaVeVip, giaVeHangNhat, loaive) VALUES (?, ?, ?, ?, ?, ?,?, ?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaVe());
            ps.setString(2, t.getMaChuyenBay());
            ps.setString(3, t.getMaKhachHang());
            ps.setDate(4, new java.sql.Date(t.getNgayDatVe().getTime()));
            ps.setInt(5, t.getThoiGianBay());
            ps.setDouble(6, t.getGiaVe());
            ps.setDouble(7, giaVeVip);
            ps.setDouble(8, giaVeHangNhat);
            ps.setString(9, t.getloaive());
            kq = ps.executeUpdate();
            System.out.println("Đã chèn thành công " + kq + " dòng!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi chèn dữ liệu: " + e.getMessage());
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
            String sql = "UPDATE Ve SET maChuyenBay = ?, maKhachHang = ?, ngayDatVe = ?,ThoiGianBay = ?, giaVe = ?, giaVeVip = ?, giaVeHangNhat = ?, loaive = ?  WHERE maVe = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaChuyenBay());
            ps.setString(2, t.getMaKhachHang());
            ps.setDate(3, new java.sql.Date(t.getNgayDatVe().getTime()));
            ps.setInt(4,t.getThoiGianBay());
            ps.setDouble(5, t.getGiaVe());
            ps.setDouble(6, t.getGiaVeVip());
            ps.setDouble(7, t.getGiaVeHangNhat());
            ps.setString(8, t.getloaive());
            ps.setString(9, t.getMaVe());
            kq = ps.executeUpdate();
            System.out.println("Đã cập nhật thành công " + kq + " dòng!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật dữ liệu: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
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

             String sql = "DELETE from Ve " +  
             "Where maVe = '"+t.getMaVe()+"'" ;    
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
            int ThoiGianBay =  rs.getInt("ThoiGianBay");
            Double giaVe = rs.getDouble("giaVe");
            Double giaVeVip = rs.getDouble("giaVeVip");
            if (rs.wasNull()) {
                giaVeVip = giaVe * 1.5;
            }
            Double giaVeHangNhat = rs.getDouble("giaVeHangNhat");
            if (rs.wasNull()) {
                giaVeHangNhat = giaVe * 3;
            }
            String loaive = rs.getString("loaive");
            String maChuyenBay = rs.getString("maChuyenBay");
            String maKhachHang = rs.getString("maKhachHang");

            Ve v = new Ve(maVe, ngayDatVe,ThoiGianBay, giaVe, giaVeVip,giaVeHangNhat,loaive, maChuyenBay, maKhachHang);
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
                rs.getInt("ThoiGianBay"),
                rs.getDouble("giaVe"),
                rs.getDouble("giaVeVip"),
                rs.getDouble("giaVeHangNhat"),
                rs.getString("loaive"),
                rs.getString("maChuyenBay"),
                rs.getString("maKhachHang")
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
                     "WHERE v.maVe = ?";;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, maVe);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            // Lấy thông tin vé
            String maVeResult = rs.getString("maVe");
            java.util.Date ngayDatVe = rs.getTimestamp("ngayDatVe");
            Double giaVe = rs.getDouble("giaVe");
            Double giaVeVip = rs.getDouble("giaVeVip");
            Double giaVeHangNhat = rs.getDouble("giaVeHangNhat");
            if (rs.wasNull()) {
                giaVeVip = giaVe * 1.5; // Nếu giá vé VIP không có, tính theo công thức
            }
            String maChuyenBay = rs.getString("maChuyenBay");
            String maKhachHang = rs.getString("maKhachHang");

            // Lấy thông tin chuyến bay
            String tenChuyenBay = rs.getString("tenChuyenBay");
            java.util.Date ngayGioKhoiHanh = rs.getTimestamp("ngayGioKhoiHanh");
            int ThoiGianBay = rs.getInt("ThoiGianBay");

            // Lấy thông tin khách hàng
            String hoTenKhachHang = rs.getString("hoTen");
            String emailKhachHang = rs.getString("email");
            String loaive= rs.getString("loaive");

            // Bạn có thể tạo class Ve mở rộng để chứa thêm thông tin, hoặc in trực tiếp
            System.out.println("Mã vé: " + maVeResult);
            System.out.println("Mã chuyến bay: " + maChuyenBay + " - Tên chuyến bay: " + tenChuyenBay);
            System.out.println("Ngày giờ khởi hành: " + ngayGioKhoiHanh);
            System.out.println("Mã khách hàng: " + maKhachHang + " - Họ tên: " + hoTenKhachHang + " - Email: " + emailKhachHang);
            System.out.println("Ngày đặt vé: " + ngayDatVe);
            System.out.println("Tổng thời gian bay: " + ThoiGianBay);
            System.out.println("Giá vé: " + giaVe);
            System.out.println("Gia vé VIP: " + giaVeVip);
            System.out.println("Giá vé hạng nhất: "+giaVeHangNhat);
            System.out.println("loaive: "+ loaive);

            // Nếu muốn trả về đối tượng Ve, bạn vẫn có thể tạo như cũ:
            Ve ve = new Ve(maVeResult, ngayDatVe,ThoiGianBay, giaVe,giaVeVip, giaVeHangNhat, loaive, maChuyenBay, maKhachHang);
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
