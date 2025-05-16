package src;

public class main {
    public static void main(String[] args) {
        ChuyenBay CB = new ChuyenBay();
        CB.nhap_thong_tin();
        CB.hienThiThongTin();
        System.out.println("Thông tin chuyến bay đã được nhập thành công.");

        KhachHang kh = new KhachHang();
        kh.nhapThongTin();
        kh.hienThiThongTin();

         Ve v= new Ve();
        v.nhapThongTin();
        v.hienThiThongTin();

    }
}