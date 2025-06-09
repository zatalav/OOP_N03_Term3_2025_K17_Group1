package src;

import java.util.List;
import java.util.Date;
import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class QuanLyChuyenBay extends manager<ChuyenBay> {

    // Định dạng ngày
    private Date parseDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Lỗi định dạng ngày tháng: " + e.getMessage());
            return null;
        }
    }

    // Nhập 1 chuyến bay
    public ChuyenBay nhap() {
        String maChuyenBay;
        while (true) {
            System.out.print("Nhập mã chuyến bay: ");
            maChuyenBay = sc.nextLine();
            if (kiemTraMaTrung(maChuyenBay)) {
                System.out.println("Mã chuyến bay đã tồn tại, vui lòng nhập lại.");
            } else
                break;
        }

        System.out.print("Nhập tên chuyến bay: ");
        String tenChuyenBay = sc.nextLine();

        Date ngayGioKhoiHanh;
        while (true) {
            System.out.print("Nhập ngày giờ khởi hành (dd/MM/yyyy HH:mm): ");
            ngayGioKhoiHanh = parseDate(sc.nextLine());
            if (ngayGioKhoiHanh != null)
                break;
        }

        int soLuongGhe;
        while (true) {
            System.out.print("Nhập số ghế trống: ");
            try {
                soLuongGhe = Integer.parseInt(sc.nextLine());
                if (soLuongGhe >= 0)
                    break;
                else
                    System.out.println("Số ghế phải >= 0.");
            } catch (NumberFormatException e) {
                System.out.println(" Nhập sai định dạng. Vui lòng nhập số nguyên.");
            }
        }

        System.out.print("Nhập điểm khởi hành: ");
        String diemKhoiHanh = sc.nextLine();

        System.out.print("Nhập điểm đến: ");
        String diemDen = sc.nextLine();

        return new ChuyenBay(maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, soLuongGhe, diemKhoiHanh, diemDen);
    }

    // Thêm chuyến bay
    public void them() {
        add();
    }

    // Sửa chuyến bay theo mã
    public void sua(String maChuyenBay) {
        ChuyenBay cb = timTheoMa(maChuyenBay);
        if (cb == null) {
            System.out.println("Không tìm thấy chuyến bay có mã: " + maChuyenBay);
            return;
        }

        System.out.println("=== Cập nhật thông tin chuyến bay [" + maChuyenBay + "] ===");

        System.out.print("Tên chuyến bay mới: ");
        cb.setTenChuyenBay(sc.nextLine());

        Date ngayGioMoi;
        while (true) {
            System.out.print("Ngày giờ khởi hành mới (dd/MM/yyyy HH:mm): ");
            ngayGioMoi = parseDate(sc.nextLine());
            if (ngayGioMoi != null)
                break;
        }
        cb.setNgayGioKhoiHanh(ngayGioMoi);

        int soGheMoi;
        while (true) {
            System.out.print("Số lượng ghế mới: ");
            try {
                soGheMoi = Integer.parseInt(sc.nextLine());
                if (soGheMoi > 0)
                    break;
                else
                    System.out.println("Số ghế phải > 0.");
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng. Nhập lại:");
            }
        }
        cb.setSoGheTrong(soGheMoi);

        System.out.print("Điểm khởi hành mới: ");
        cb.setDiemKhoiHanh(sc.nextLine());

        System.out.print("Điểm đến mới: ");
        cb.setDiemDen(sc.nextLine());

        System.out.println("Đã cập nhật chuyến bay thành công!");
    }

    // Xoá chuyến bay
    public void xoa(String maChuyenBay) {
        boolean removed = ds.removeIf(cb -> cb.getMaChuyenBay().equalsIgnoreCase(maChuyenBay));
        if (removed) {
            System.out.println(" Đã xoá chuyến bay: " + maChuyenBay);
        } else {
            System.out.println("Không tìm thấy chuyến bay để xoá.");
        }
    }

    // Hiển thị danh sách
    public void hienThiThongTin() {
        if (ds.isEmpty()) {
            System.out.println("📭 Không có chuyến bay nào.");
            return;
        }
        System.out.println("===== DANH SÁCH CHUYẾN BAY =====");
        for (ChuyenBay cb : ds) {
            System.out.println(cb);
        }
    }

    // Tìm chuyến bay theo mã
    public ChuyenBay timTheoMa(String ma) {
        for (ChuyenBay cb : ds) {
            if (cb.getMaChuyenBay().equalsIgnoreCase(ma)) {
                return cb;
            }
        }
        return null;
    }

    // Ghi dữ liệu vào file nhị phân
    public void luuDuLieu() {
        File file = new File("./btl/chuyenbay.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(ds);
            System.out.println("Đã lưu dữ liệu chuyến bay.");
        } catch (IOException e) {
            System.out.println("Ghi dữ liệu chuyến bay bị lỗi.");
            e.printStackTrace();
        }
    }

    // Đọc dữ liệu từ file nhị phân
    @SuppressWarnings("unchecked")
    public void docDuLieu() {
        File file = new File("./btl/chuyenbay.dat");
        if (!file.exists()) {
            System.out.println("❗ File dữ liệu chưa tồn tại.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<ChuyenBay> dsChuyenBay = (List<ChuyenBay>) ois.readObject();
            ds.clear();
            ds.addAll(dsChuyenBay);
            System.out.println("Đã đọc dữ liệu chuyến bay.");
        } catch (Exception e) {
            System.out.println("Đọc dữ liệu chuyến bay bị lỗi.");
            e.printStackTrace();
        }
    }

    // Xuất danh sách chuyến bay ra file text
    public void xuatFileText() {
        File file = new File("./btl/chuyenbay.txt");
        file.getParentFile().mkdirs();

        try (PrintWriter pw = new PrintWriter(file)) {
            for (ChuyenBay cb : ds) {
                pw.println(cb);
            }
            System.out.println("Đã xuất dữ liệu ra file chuyenbay.txt!");
        } catch (Exception e) {
            System.out.println("Xuất file thất bại!");
            e.printStackTrace();
        }
    }
}
