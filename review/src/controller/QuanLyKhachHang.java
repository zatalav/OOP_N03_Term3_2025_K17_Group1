package src.controller;

import src.database.dataQuanLyKhachHang;
import src.model.KhachHang;
import java.util.ArrayList;

public class QuanLyKhachHang extends manager<KhachHang> {
    public String PHONE_REGEX = "^\\+[0-9]{9,14}$";
    public String regex = "^CB\\d{3}_KH\\d{3}$";

    public KhachHang nhap() {
        loadFromDatabase();
        String maKhachHang;
        while (true) {
            System.out.println("Nhập mã khách hàng:");
            maKhachHang = sc.nextLine().toUpperCase().trim();
            if (!maKhachHang.matches("^CB\\d{3}_KH\\d{3}$")) {
                System.out.println("Sai định dạng mã(VD: CB001_KH123). Nhập lại:");
            } else if (kiemTraMaTrung(maKhachHang)) {
                System.out.println("Mã khách hàng đã tồn tại, vui lòng nhập lại.");
            } else {
                break;
            }
        }
        System.out.println("Nhập tên khách hàng: ");
        String hoTen = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        String soDienThoai;
        System.out.println("Nhập số điện thoại(VD: +84345782790): ");
        while (true) {
            soDienThoai = sc.nextLine();
            if (soDienThoai.matches(PHONE_REGEX))
                break;
            System.out.println("Số điện thoại không hợp lệ, nhập lại:");
        }
        System.out.println("Nhập căn cước công dân: ");
        String canCuocCongDan = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String diaChi = sc.nextLine();

        return new KhachHang(maKhachHang, hoTen, email, soDienThoai, canCuocCongDan, diaChi);
    }

    public void them() {
        KhachHang kh = nhap();
        ds.add(kh);
        dataQuanLyKhachHang dao = new dataQuanLyKhachHang();
        dao.insert(kh);
    }

    public void loadFromDatabase() {
        ds.clear();
        dataQuanLyKhachHang dao = new dataQuanLyKhachHang();
        ArrayList<KhachHang> danhSach = dao.selectAll();
        ds.addAll(danhSach);
    }

    public void xoa() {
        KhachHang cbxoa = null;
        System.out.println("Nhập mã khách hàng: ");
        String maKhachHang = sc.nextLine();
        for (KhachHang cb : ds) {
            if (cb.getMaKhachHang().equals(maKhachHang)) {
                cbxoa = cb;
                break;
            }
        }

        if (cbxoa != null) {
            ds.remove(cbxoa);
            dataQuanLyKhachHang dao = new dataQuanLyKhachHang();
            dao.delete(cbxoa);
            System.out.println("Đã xóa khách hàng có mã: " + maKhachHang);
        } else {
            System.out.println("Không tìm thấy khách hàng với mã: " + maKhachHang);
        }
    }

    public void sua() {
        loadFromDatabase();
        KhachHang khsua = null;
        System.out.println("Nhập mã khách hàng: ");
        String maKhachHang = sc.nextLine();
        for (KhachHang kh : ds) {
            if (kh.getMaKhachHang().equals(maKhachHang)) {
                khsua = kh;
                break;
            }
        }

        if (khsua != null) {
            System.out.println("Nhập tên khách hàng: ");
            khsua.setHoTen(sc.nextLine());
            System.out.println("Nhập email: ");
            khsua.setEmail(sc.nextLine());
            String SoDienThoai;
            while (true) {
                System.out.println("Nhập số điện thoại (ví dụ: +84981015263): ");
                SoDienThoai = sc.nextLine();
                if (SoDienThoai.matches(PHONE_REGEX)) {
                    khsua.setSoDienThoai(SoDienThoai);
                    break;
                } else {
                    System.out.println("Số điện thoại không hợp lệ, nhập lại:");
                }
            }
            System.out.println("Nhập căn cước công dân: ");
            khsua.setCanCuocCongDan(sc.nextLine());
            System.out.println("Nhập địa chỉ: ");
            khsua.setDiaChi(sc.nextLine());

            dataQuanLyKhachHang dao = new dataQuanLyKhachHang();
            dao.update(khsua);
            System.out.println("Đã cập nhật khách hàng có mã: " + maKhachHang);
        } else {
            System.out.println("Không tìm thấy khách hàng với mã: " + maKhachHang);
        }
    }

    public void lietKe() {
        dataQuanLyKhachHang dao = new dataQuanLyKhachHang();
        ArrayList<KhachHang> dsKH = dao.selectAll();
        if (dsKH.isEmpty()) {
            System.out.println("Danh sách khách hàng rỗng.");
        } else {
            System.out.println("Danh sách khách hàng:");
            for (KhachHang kh : dsKH) {
                System.out.println(kh);
            }
        }
    }

    public void timKiem() {
        System.out.println("Nhập mã khách hàng cần tìm: ");
        String maKhachHang = sc.nextLine();
        dataQuanLyKhachHang dao = new dataQuanLyKhachHang();
        ArrayList<KhachHang> ketQua = dao.selectByCondition(maKhachHang);
        if (!ketQua.isEmpty()) {
            for (KhachHang kh : ketQua) {
                System.out.println("Khách hàng tìm thấy: " + kh);
            }
        } else {
            System.out.println("Không tìm thấy khách hàng với mã: " + maKhachHang);
        }
    }
}
