package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuanLyChuyenBay extends manager<ChuyenBay> {

    // hàm định dạng giờ
    private Date parseDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Loi dinh dang ngay thang: " + e.getMessage());
            return null;
        }
    }
// hàm nhập thông tin chuyến baybay
    public ChuyenBay nhap(){
        String maChuyenBay;
        while(true){
            System.out.println("nhap ma chuyen bay:");
            maChuyenBay = sc.nextLine();
            if(kiemTraMaTrung(maChuyenBay)){
                System.out.println("Ma chuyen bay da ton tai, vui long nhap lai.");
            } else {
                break;
            }
        }
        System.out.println("Nhap ten chuyen bay: ");
        String tenChuyenbay = sc.nextLine();
        Date ngayGioKhoiHanh=null;
        do {
            System.out.println("Nhap ngay gio khoi hanh (dd/MM/yyyy hh:mm): ");
            String ngayGioKhoiHanhStr = sc.nextLine();
            ngayGioKhoiHanh = parseDate(ngayGioKhoiHanhStr);
        } while (ngayGioKhoiHanh == null);
        System.out.println("Nhap so ghe trong: ");
        int soLuongGhe;
        while (true) {
            try {
                soLuongGhe = Integer.parseInt(sc.nextLine());
                if (soLuongGhe < 0) {
                    System.out.println("So ghe trong phai la so duong. Vui long nhap lai.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai dinh dang, vui long nhap lai so ghe trong: ");
            }
        }
        System.out.println("Nhap diem khoi hanh: ");
        String diemKhoiHanh = sc.nextLine();
        System.out.println("Nhap diem den: ");
        String diemDen = sc.nextLine();
        return new ChuyenBay(maChuyenBay, tenChuyenbay, ngayGioKhoiHanh, soLuongGhe, diemKhoiHanh, diemDen);
    }

    public void them(){
        add();
    }

    public void sua(String maChuyenBay){
        edit();
    }

    public void xoa(String maChuyenBay){
        delete();
    }

    public void hienThiThongTin() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        System.out.println("\n================= THÔNG TIN CHUYẾN BAY =================");
        for (ChuyenBay cb : ds) {
        System.out.printf("| %-20s | %-30s |\n", "Mã chuyến bay", cb.getMaChuyenBay());
        System.out.printf("| %-20s | %-30s |\n", "Tên chuyến bay", cb.getTenChuyenBay());
        System.out.printf("| %-20s | %-30s |\n", "Ngày giờ khởi hành", sdf.format(cb.getNgayGioKhoiHanh()));
        System.out.printf("| %-20s | %-30d |\n", "Số lượng ghế", cb.getSoLuongGhe());
        System.out.printf("| %-20s | %-30s |\n", "Điểm khởi hành", cb.getDiemKhoiHanh());
        System.out.printf("| %-20s | %-30s |\n", "Điểm đến", cb.getDiemDen());
        System.out.println("--------------------------------------------------------");
    }
        System.out.println("========================================================");
    }
}