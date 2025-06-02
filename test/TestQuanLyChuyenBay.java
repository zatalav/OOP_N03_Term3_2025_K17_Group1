package src;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestQuanLyChuyenBay {
    public static void testAddChuyenBay() {
        QuanLyChuyenBay quanLy = new QuanLyChuyenBay();
        String input = "VN123\nFlight VN123\n01-06-2025 14:30\n100\nHanoi\nHo Chi Minh\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        quanLy.addChuyenBay(scanner);

        if (quanLy.getDanhSachChuyenBay().size() == 1) {
            ChuyenBay cb = quanLy.getDanhSachChuyenBay().get(0);
            System.out.println("Test Thêm Chuyến Bay: OK");
            System.out.println("Mã: " + cb.getMaChuyenBay());
            System.out.println("Tên: " + cb.getTenChuyenBay());
            System.out.println("Số ghế: " + cb.getSoLuongGhe());
            System.out.println("Điểm khởi hành: " + cb.getDiemKhoiHanh());
            System.out.println("Điểm đến: " + cb.getDiemDen());
        } else {
            System.out.println("Test Thêm Chuyến Bay: FAIL");
        }
    }

    public static void testShowChuyenBay() {
        QuanLyChuyenBay quanLy = new QuanLyChuyenBay();
        String input = "VN123\nFlight VN123\n01-06-2025 14:30\n100\nHanoi\nHo Chi Minh\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        quanLy.addChuyenBay(scanner);

        System.out.println("=== Test Hiển Thị Chuyến Bay ===");
        quanLy.showChuyenBay();
    }

    public static void testDeleteChuyenBay() {
        QuanLyChuyenBay quanLy = new QuanLyChuyenBay();
        String inputAdd = "VN123\nFlight VN123\n01-06-2025 14:30\n100\nHanoi\nHo Chi Minh\n";
        ByteArrayInputStream inAdd = new ByteArrayInputStream(inputAdd.getBytes());
        Scanner scannerAdd = new Scanner(inAdd);
        quanLy.addChuyenBay(scannerAdd);

        String inputDelete = "VN123\n";
        ByteArrayInputStream inDelete = new ByteArrayInputStream(inputDelete.getBytes());
        Scanner scannerDelete = new Scanner(inDelete);
        quanLy.deleteChuyenBay(scannerDelete);

        if (quanLy.getDanhSachChuyenBay().isEmpty()) {
            System.out.println("Test Xóa Chuyến Bay: OK");
        } else {
            System.out.println("Test Xóa Chuyến Bay: FAIL");
        }
    }

    public static void testDeleteChuyenBayNotFound() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        QuanLyChuyenBay quanLy = new QuanLyChuyenBay();
        String inputDelete = "VN999\n";
        ByteArrayInputStream inDelete = new ByteArrayInputStream(inputDelete.getBytes());
        Scanner scannerDelete = new Scanner(inDelete);
        quanLy.deleteChuyenBay(scannerDelete);

        System.setOut(originalOut);

        if (outContent.toString().contains("Không tìm thấy mã chuyến bay này!")) {
            System.out.println("Test Xóa Chuyến Bay Không Tồn Tại: OK");
        } else {
            System.out.println("Test Xóa Chuyến Bay Không Tồn Tại: FAIL");
        }
    }

    // Thêm hàm main để chạy tất cả các test
    public static void main(String[] args) {
        testAddChuyenBay();
        testShowChuyenBay();
        testDeleteChuyenBay();
        testDeleteChuyenBayNotFound();
    }
}