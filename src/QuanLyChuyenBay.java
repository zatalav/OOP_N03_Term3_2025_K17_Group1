package src;

import java.util.List;
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
            System.out.println("Lỗi định dạng ngày tháng: " + e.getMessage());
            return null;
        }
    }

    // hàm nhập thông tin chuyến bay
    public ChuyenBay nhap() {
        String maChuyenBay;
        while (true) {
            System.out.println("Nhập mã chuyến bay:");
            maChuyenBay = sc.nextLine();
            if (kiemTraMaTrung(maChuyenBay)) {
                System.out.println("Mã chuyến bay đã tồn tại, vui lòng nhập lại.");
            } else {
                break;
            }
        }
        System.out.println("Nhập tên chuyến bay: ");
        String tenChuyenbay = sc.nextLine();
        Date ngayGioKhoiHanh = null;
        do {
            System.out.println("Nhập ngày giờ khởi hành (dd/MM/yyyy hh:mm): ");
            String ngayGioKhoiHanhStr = sc.nextLine();
            ngayGioKhoiHanh = parseDate(ngayGioKhoiHanhStr);
        } while (ngayGioKhoiHanh == null);
        System.out.println("Nhap so ghe trong: ");
        int soLuongGhe;
        while (true) {
            try {
                soLuongGhe = Integer.parseInt(sc.nextLine());
                if (soLuongGhe < 0) {
                    System.out.println("Số ghế trống phải là số dương. Vui lòng nhập lại.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại số ghế trống: ");
            }
        }
        System.out.println("Nhập điểm khởi hành: ");
        String diemKhoiHanh = sc.nextLine();
        System.out.println("Nhập điểm đến: ");
        String diemDen = sc.nextLine();
        return new ChuyenBay(maChuyenBay, tenChuyenbay, ngayGioKhoiHanh, soLuongGhe, diemKhoiHanh, diemDen);
    }

    public void them() {
        add();
    }

    public void sua(String maChuyenBay) {
        edit();
    }

    public void xoa(String maChuyenBay) {
        delete();
    }

    public void hienThiThongTin() {
        for (ChuyenBay chuyenBay : ds) {
            System.out.println(chuyenBay.toString());
        }
    }

    public ChuyenBay timTheoMa(String ma) {
        for (ChuyenBay cb : ds) {
            if (cb.getMaChuyenBay().equalsIgnoreCase(ma)) {
                return cb;
            }
        }
        return null;
    }

    public void luuDuLieu() {
        File file = new File("./btl/chuyenbay.dat");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(ds);
        } catch (IOException e) {
            System.out.println("Ghi dữ liệu chuyến bay xảy ra lỗi");
            e.printStackTrace();
        }
    }

    @SuppressWarnings({"unchecked", "resource"})
    public void docDuLieu() {
        File file = new File("./btl/chuyenbay.dat");
        FileInputStream fileinputStream = null;
        ObjectInputStream inputStream = null;

        if (!file.exists()) {
            System.out.println("File không tồn tại");
            return;
        }

        try {
            fileinputStream = new FileInputStream(file);
            inputStream = new ObjectInputStream(fileinputStream);
            List<ChuyenBay> dsChuyenBay = (List<ChuyenBay>) inputStream.readObject();
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
                pw.println(cb);
            }
            System.out.println("Đã xuất dữ liệu chuyến bay ra file chuyenbay.txt!");
        } catch (Exception e) {
            System.out.println("Xuất file text thất bại!");
            e.printStackTrace();
        }
    }
}
