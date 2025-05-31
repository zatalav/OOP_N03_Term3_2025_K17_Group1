package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class MaChuyenBay {
    public static boolean kiemTraMaHopLe(String ma) {
        return ma.matches("^[A-Z]{2}\\d{3,4}$");
    }
}

class nhap_thong_tin{
    public static String nhapTenChuyenBay(Scanner scanner) {
        System.out.print("Nhập tên chuyến bay: ");
        return scanner.nextLine();
    }

    public static int nhapSoLuongGhe(Scanner scanner) {
        System.out.print("Nhập số lượng ghế: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            scanner.next(); 
        }
        int soLuong = scanner.nextInt();
        scanner.nextLine(); 
        return soLuong;
    }

    public static Date nhapNgayGioKhoiHanh(Scanner scanner) {
        System.out.print("Nhập ngày giờ khởi hành (dd-MM-yyyy HH:mm): ");
        while (true) {
            String ngayGioKhoiHanhStr = scanner.nextLine();
            Date ngayGioKhoiHanh = parseDate(ngayGioKhoiHanhStr);
            if (ngayGioKhoiHanh != null) {
                return ngayGioKhoiHanh;
            } else {
                System.out.println("Định dạng ngày giờ không hợp lệ. Vui lòng nhập lại (dd-MM-yyyy HH:mm): ");
            }
        }
    }

    public static String nhapDiemKhoiHanh(Scanner scanner) {
        String diem;
        while (true) {
            System.out.print("Nhập điểm khởi hành: ");
            diem = scanner.nextLine();
            if (!diem.trim().isEmpty()) return diem;
            System.out.println("Điểm khởi hành không được để trống. Vui lòng nhập lại.");
        }
    }

    public static String nhapDiemDen(Scanner scanner) {
        String diem;
        while (true) {
            System.out.print("Nhập điểm đến: ");
            diem = scanner.nextLine();
            if (!diem.trim().isEmpty()) return diem;
            System.out.println("Điểm đến không được để trống. Vui lòng nhập lại.");
        }
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        sdf.setLenient(false);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }
}

public class ChuyenBay {
    private String maChuyenBay;
    private String tenChuyenBay;
    private Date ngayGioKhoiHanh;
    private int soLuongGhe;
    private String diemKhoiHanh;
    private String diemDen;

    public ChuyenBay() {
    }

    public ChuyenBay(String maChuyenBay, String tenChuyenBay, Date ngayGioKhoiHanh, int soLuongGhe, String diemKhoiHanh, String diemDen) {
        this.maChuyenBay = maChuyenBay;
        this.tenChuyenBay = tenChuyenBay;
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
        this.soLuongGhe = soLuongGhe;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
    }

    public void nhap_thong_tin() {
    Scanner scanner = new Scanner(System.in);

        
    while (true) {
        System.out.print("Nhập mã chuyến bay (VD: VN123): ");
        maChuyenBay = scanner.nextLine();
        if (MaChuyenBay.kiemTraMaHopLe(maChuyenBay)) break;
        System.out.println("Mã chuyến bay không hợp lệ. Vui lòng nhập lại.");
    }

    tenChuyenBay = nhap_thong_tin.nhapTenChuyenBay(scanner);
    ngayGioKhoiHanh = nhap_thong_tin.nhapNgayGioKhoiHanh(scanner);
    soLuongGhe = nhap_thong_tin.nhapSoLuongGhe(scanner);
    diemKhoiHanh = nhap_thong_tin.nhapDiemKhoiHanh(scanner);
    diemDen = nhap_thong_tin.nhapDiemDen(scanner);
  
}

    public void hienThiThongTin() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        System.out.println("\n================= THÔNG TIN CHUYẾN BAY =================");
        System.out.printf("| %-20s | %-30s |\n", "Mã chuyến bay", maChuyenBay);
        System.out.printf("| %-20s | %-30s |\n", "Tên chuyến bay", tenChuyenBay);
        System.out.printf("| %-20s | %-30s |\n", "Ngày giờ khởi hành", sdf.format(ngayGioKhoiHanh));
        System.out.printf("| %-20s | %-30d |\n", "Số lượng ghế", soLuongGhe);
        System.out.printf("| %-20s | %-30s |\n", "Điểm khởi hành", diemKhoiHanh);
        System.out.printf("| %-20s | %-30s |\n", "Điểm đến", diemDen);
        System.out.println("========================================================");
    }


    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getTenChuyenBay() {
        return tenChuyenBay;
    }

    public void setTenChuyenBay(String tenChuyenBay) {
        this.tenChuyenBay = tenChuyenBay;
    }

    public Date getNgayGioKhoiHanh() {
        return ngayGioKhoiHanh;
    }

    public void setNgayGioKhoiHanh(Date ngayGioKhoiHanh) {
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public String getDiemKhoiHanh() {
        return diemKhoiHanh;
    }

    public void setDiemKhoiHanh(String diemKhoiHanh) {
        this.diemKhoiHanh = diemKhoiHanh;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }
}