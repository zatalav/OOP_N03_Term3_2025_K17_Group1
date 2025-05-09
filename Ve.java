import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;

class Ma_ve implements Serializable {
    private String ma;
    public Ma_ve(String ma) {
        if (ma == null || ma.isEmpty()) {
            throw new IllegalArgumentException("Mã vé không được để trống.");
        }
        this.ma = ma;
    }
    public String lay_ma() {
        return ma;
    }
    public void dat_ma(String ma) {
        if (ma != null && !ma.isEmpty()) {
            this.ma = ma;
        }
    }
    public String toString() {
        return ma;
    }
}

class Chuyen_bay implements Serializable {
    private String ma_chuyen_bay;
    private String ten_chuyen_bay;
    private String diem_den;
    private LocalDateTime thoi_gian_khoi_hanh;

    public Chuyen_bay(String ma_chuyen_bay, String ten_chuyen_bay, String diem_den, LocalDateTime thoi_gian_khoi_hanh) {
        this.ma_chuyen_bay = ma_chuyen_bay;
        this.ten_chuyen_bay = ten_chuyen_bay;
        this.diem_den = diem_den;
        this.thoi_gian_khoi_hanh = thoi_gian_khoi_hanh;
    }

    public String toString() {
        return ten_chuyen_bay + " - " + diem_den + " - " + thoi_gian_khoi_hanh;
    }
}

class Hanh_khach implements Serializable {
    private String ma_hanh_khach;
    private String ho_ten;
    private String email;

    public Hanh_khach(String ma_hanh_khach, String ho_ten, String email) {
        this.ma_hanh_khach = ma_hanh_khach;
        this.ho_ten = ho_ten;
        this.email = email;
    }

    public String toString() {
        return ho_ten + " (" + email + ")";
    }
}

class Gia_ve implements Serializable {
    private double so_tien;

    public Gia_ve(double so_tien) {
        if (so_tien < 0) {
            throw new IllegalArgumentException("Giá vé không hợp lệ.");
        }
        this.so_tien = so_tien;
    }

    public String toString() {
        return so_tien + " VND";
    }
}

public class Ve implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;

    private Ma_ve ma_ve;
    private Chuyen_bay chuyen_bay;
    private Hanh_khach hanh_khach;
    private Gia_ve gia_ve;

    public Ve(Ma_ve ma_ve, Chuyen_bay chuyen_bay, Hanh_khach hanh_khach, Gia_ve gia_ve) {
        this.ma_ve = ma_ve;
        this.chuyen_bay = chuyen_bay;
        this.hanh_khach = hanh_khach;
        this.gia_ve = gia_ve;
    }

    public void in_thong_tin_ve() {
        System.out.println("===== THÔNG TIN VÉ =====");
        System.out.println("Mã vé       : " + ma_ve);
        System.out.println("Khách hàng  : " + hanh_khach);
        System.out.println("Chuyến bay  : " + chuyen_bay);
        System.out.println("Giá vé      : " + gia_ve);
        System.out.println("========================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã vé: ");
        Ma_ve ma_ve = new Ma_ve(sc.nextLine());

        System.out.print("Nhập mã chuyến bay: ");
        String ma_cb = sc.nextLine();
        System.out.print("Nhập tên chuyến bay: ");
        String ten_cb = sc.nextLine();
        System.out.print("Nhập điểm đến: ");
        String diem_den = sc.nextLine();
        System.out.print("Nhập thời gian khởi hành (yyyy-MM-ddTHH:mm): ");
        String thoigian = sc.nextLine();
        LocalDateTime thoi_gian_khoi_hanh = LocalDateTime.parse(thoigian);
        Chuyen_bay cb = new Chuyen_bay(ma_cb, ten_cb, diem_den, thoi_gian_khoi_hanh);

        System.out.print("Nhập mã hành khách: ");
        String ma_kh = sc.nextLine();
        System.out.print("Nhập họ tên hành khách: ");
        String ten_kh = sc.nextLine();
        System.out.print("Nhập email hành khách: ");
        String email = sc.nextLine();
        Hanh_khach hk = new Hanh_khach(ma_kh, ten_kh, email);

        System.out.print("Nhập giá vé: ");
        double gia = sc.nextDouble();
        Gia_ve gv = new Gia_ve(gia);

        Ve ve = new Ve(ma_ve, cb, hk, gv);
        ve.in_thong_tin_ve();

        sc.close();
    }
}
