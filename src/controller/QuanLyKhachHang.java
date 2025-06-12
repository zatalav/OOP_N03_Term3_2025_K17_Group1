package src.controller;

import java.io.*;
import java.util.*;

import src.model.KhachHang;

public class QuanLyKhachHang extends manager<KhachHang> {

    public KhachHang nhap() {
        String ma;
        while (true) {
            System.out.print("Nhập mã khách hàng: ");
            ma = sc.nextLine();
            if (kiemTraMaTrung(ma)) {
                System.out.println("Mã khách hàng đã tồn tại, vui lòng nhập lại.");
            } else {
                break;
            }
        }

        System.out.print("Nhập họ tên khách hàng: ");
        String hoTen = sc.nextLine();

        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String sdt = sc.nextLine();

        String cccd;
        while (true) {
            System.out.print("Nhập căn cước công dân (12 chữ số): ");
            cccd = sc.nextLine();
            if (cccd.matches("^\\d{12}$")) {
                break;
            } else {
                System.out.println("CCCD không hợp lệ. Vui lòng nhập lại.");
            }
        }

        return new KhachHang(ma, hoTen, email, sdt, cccd);
    }

    public void them() {
        add();
    }

    public void sua(String ma) {
        for (KhachHang kh : ds) {
            if (kh.getMaKhachHang().equals(ma)) {
                System.out.println("Nhập thông tin mới cho khách hàng có mã: " + ma);

                System.out.print("Nhập họ tên mới: ");
                kh.setHoTen(sc.nextLine());

                System.out.print("Nhập email mới: ");
                kh.setEmail(sc.nextLine());

                System.out.print("Nhập số điện thoại mới: ");
                kh.setSoDienThoai(sc.nextLine());

                String cccd;
                while (true) {
                    System.out.print("Nhập CCCD mới (12 chữ số): ");
                    cccd = sc.nextLine();
                    if (cccd.matches("^\\d{12}$")) {
                        break;
                    } else {
                        System.out.println("CCCD không hợp lệ. Vui lòng nhập lại.");
                    }
                }
                kh.setCanCuocCongDan(cccd);

                System.out.println("Đã cập nhật thông tin khách hàng.");
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng có mã: " + ma);
    }

    public void xoa(String ma) {
        boolean removed = ds.removeIf(kh -> kh.getMaKhachHang().equals(ma));
        if (removed) {
            System.out.println("Đã xoá khách hàng có mã: " + ma);
        } else {
            System.out.println("Không tìm thấy khách hàng để xoá.");
        }
    }

    public void hienThiThongTin() {
        for (KhachHang kh : ds) {
            System.out.println(kh.toString());
        }
    }

    public void luuDuLieu() {
        File file = new File("./btl/khachhang.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(ds);
            System.out.println("Đã lưu danh sách khách hàng thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu dữ liệu khách hàng:");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void docDuLieu() {
        File file = new File("./btl/khachhang.dat");
        if (!file.exists()) {
            System.out.println("File không tồn tại!");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<KhachHang> dsDoc = (List<KhachHang>) ois.readObject();
            ds.clear();
            ds.addAll(dsDoc);
            System.out.println("Đã đọc dữ liệu khách hàng thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc dữ liệu khách hàng:");
            e.printStackTrace();
        }
    }

    public void xuatFileText() {
        File file = new File("./btl/khachhang.txt");
        file.getParentFile().mkdirs();
        try (PrintWriter pw = new PrintWriter(file)) {
            for (KhachHang kh : ds) {
                pw.println(kh);
            }
            System.out.println("Đã xuất dữ liệu khách hàng ra file khachhang.txt!");
        } catch (IOException e) {
            System.out.println("Xuất file text thất bại!");
            e.printStackTrace();
        }
    }
}
