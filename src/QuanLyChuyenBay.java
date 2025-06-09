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
        ChuyenBay cb = timTheoMa(maChuyenBay);
        if (cb == null) {
            System.out.println("Không tìm thấy chuyến bay có mã: " + maChuyenBay);
            return;
        }

        System.out.println("Nhập thông tin mới cho chuyến bay [" + maChuyenBay + "]");

        System.out.print("Tên chuyến bay mới: ");
        cb.setTenChuyenBay(sc.nextLine());

        Date ngayGioMoi;
        do {
            System.out.print("Ngày giờ khởi hành mới (dd/MM/yyyy hh:mm): ");
            String input = sc.nextLine();
            ngayGioMoi = parseDate(input);
        } while (ngayGioMoi == null);
        cb.setNgayGioKhoiHanh(ngayGioMoi);

        System.out.print("Số lượng ghế mới: ");
        int soGheMoi;
        while (true) {
            try {
                soGheMoi = Integer.parseInt(sc.nextLine());
                if (soGheMoi > 0) break;
                else System.out.println("Số ghế phải > 0. Nhập lại:");
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng. Nhập lại:");
            }
        }
        cb.setSoGheTrong(soGheMoi);

        System.out.print("Điểm khởi hành mới: ");
        cb.setDiemKhoiHanh(sc.nextLine());

        System.out.print("Điểm đến mới: ");
        cb.setDiemDen(sc.nextLine());

        System.out.println("✅ Đã cập nhật chuyến bay thành công!");
    }


    public void xoa(String maChuyenBay) {
        boolean removed = ds.removeIf(cb -> cb.getMaChuyenBay().equalsIgnoreCase(maChuyenBay));
        if (removed) {
            System.out.println("✅ Đã xoá chuyến bay có mã: " + maChuyenBay);
        } else {
            System.out.println("❌ Không tìm thấy chuyến bay để xoá.");
        }
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
