import java.util.Scanner;

public class KhachHang {
    private String maKhachHang;
    private String hoTen;
    private String email;
    private String soDienThoai;

    public KhachHang() {
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma khach hang: ");
        maKhachHang = scanner.nextLine().trim();

        System.out.print("Nhap ho va ten: ");
        hoTen = scanner.nextLine().trim();

        System.out.print("Nhap email: ");
        email = scanner.nextLine().trim();

        System.out.print("Nhap so dien thoai: ");
        soDienThoai = scanner.nextLine().trim();
    }

    public void hienThiThongTin() {
        System.out.println("\n----- Thong tin khach hang -----");
        System.out.println("Ma khach hang : " + maKhachHang);
        System.out.println("Ho va ten     : " + hoTen);
        System.out.println("Email         : " + email);
        System.out.println("So dien thoai : " + soDienThoai);
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        KhachHang kh = new KhachHang();
        kh.nhapThongTin();
        kh.hienThiThongTin();
    }
}
