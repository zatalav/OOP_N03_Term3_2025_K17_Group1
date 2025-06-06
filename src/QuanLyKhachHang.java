package src;

import java.io.*;
import java.util.*;

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

        return new KhachHang(ma, hoTen, email, sdt);
    }

    public void them() {
        add();
    }

    public void sua(String ma) {
        edit();
    }

    public void xoa(String ma) {
        delete();
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
                pw.println(kh); // dùng toString()
            }
            System.out.println("Đã xuất dữ liệu khách hàng ra file khachhang.txt!");
        } catch (IOException e) {
            System.out.println("Xuất file text thất bại!");
            e.printStackTrace();
        }
    }
}
