public class Test_KhachHang {
    public static void main(String[] args) {
        try {
            // Tao du lieu mau
            String maKhachHang = "KH001";
            String hoVaTen = "Chu Van An";
            String email = "chuvanan@gmail.com";
            String soDienThoai = "0123456789";

            // Tao doi tuong KhachHang
            KhachHang kh = new KhachHang(maKhachHang, hoVaTen, email, soDienThoai);

            // Hien thi thong tin de kiem tra
            kh.hienThiThongTin();
        } catch (Exception e) {
            System.out.println("Test that bai: Co loi xay ra - " + e.getMessage());
        }
    }
}
