package src;
import test.TestQuanLyChuyenBay;

public class App {
    public static void main(String[] args) {
        System.out.println("----- Test Thêm Chuyến Bay -----");
        TestQuanLyChuyenBay.testAddChuyenBay();

        System.out.println("\n----- Test Hiển Thị Chuyến Bay -----");
        TestQuanLyChuyenBay.testShowChuyenBay();

        System.out.println("\n----- Test Xóa Chuyến Bay -----");
        TestQuanLyChuyenBay.testDeleteChuyenBay();

        System.out.println("\n----- Test Xóa Chuyến Bay Không Tồn Tại -----");
        TestQuanLyChuyenBay.testDeleteChuyenBayNotFound();

        System.out.println("\n----- Tất cả test hoàn thành -----");
    }
}