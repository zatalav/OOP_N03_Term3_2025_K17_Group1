package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

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
        for (ChuyenBay chuyenBay : ds) {
            System.out.println(chuyenBay.toString());
    }

    public void luuDuLieu() {
        File file = new File("./btl/chuyenbay.dat");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            outputStream = new ObjectOutputStream(fileOutputStream);
            // ghi danh sách chuyến bay vao file
            outputStream.writeObject(ds);
        } catch (IOException e) {
            System.out.println("Ghi dữ liệu chuyến bay xảy ra lỗi");
            e.printStackTrace();
        }
    }

    public void docDuLieu() {
        File file = new File("./btl/chuyenbay.dat");
        // class hỗ trợ ghi file
        FileInputStream fileinputStream = null;
        ObjectInputStream inputStream = null;

        // Kiểm tra file có tồn tại hay không
        if (!file.exists()) {
            System.out.println("File không tồn tại");
            return;
        }

        try {
            fileinputStream = new FileInputStream(file);
            inputStream = new ObjectInputStream(fileinputStream);
            // đọc danh sách chuyến bay từ file
            List<ChuyenBay> dsChuyenBay = (List<ChuyenBay>) inputStream.readObject();
//            danhSachChuyenBay.clear();
            ds.addAll(dsChuyenBay);
        } catch (Exception e) {
            System.out.println("Đọc dữ liệu chuyến bay xảy ra lỗi");
            e.printStackTrace();
        }
    }

    public void xuatFileText() {
        File file = new File("./btl/chuyenbay.txt");
        file.getParentFile().mkdirs();
        try (java.io.PrintWriter pw = new java.io.PrintWriter(file)) {
            for (ChuyenBay cb : ds) {
                pw.println(cb); // dùng toString() của ChuyenBay
            }
            System.out.println("Đã xuất dữ liệu chuyến bay ra file chuyenbay.txt!");
        } catch (Exception e) {
            System.out.println("Xuất file text thất bại!");
            e.printStackTrace();
        }
    }
}