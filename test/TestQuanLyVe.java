import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import src.QuanLyVe;
import src.QuanLyChuyenBay;
import src.ChuyenBay;

public class TestQuanLyVe {
    public static void testAddVe() {
        try {
            // Tạo quản lý chuyến bay và thêm chuyến bay giả lập
            QuanLyChuyenBay qlcb = new QuanLyChuyenBay();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date ngayGioKhoiHanh = sdf.parse("10/06/2025 08:00");

            ChuyenBay cb = new ChuyenBay("VN123", "Hà Nội - TP.HCM", ngayGioKhoiHanh, 100, "Hà Nội", "TP.HCM");
            qlcb.getDs().add(cb); // hoặc qlcb.them(cb) nếu bạn có hàm thêm

            // Tạo quản lý vé và chuẩn bị input giả lập
            QuanLyVe qlv = new QuanLyVe(qlcb);

            String input = "VE12345\nNguyen Van A\n09/06/2025\nVN123\n1500000\n2\n";
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            Scanner scanner = new Scanner(in);

            // Gọi hàm thêm vé
            qlv.addVe(scanner);

            // Kiểm tra và hiển thị kết quả
            if (qlv.getDanhSachVe().size() == 1) {
                System.out.println("===== Test: Thêm Vé =====");
                System.out.println(">> Thêm vé thành công!");
                System.out.println("=== Thông tin vé ===");
                qlv.showVe();
            } else {
                System.out.println("Thêm vé thất bại!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testAddVe();
    }
}
