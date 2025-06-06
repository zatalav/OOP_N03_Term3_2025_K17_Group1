package src;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class TestQuanLyVe {
    public static void testAddVe() {
        QuanLyVe qlv = new QuanLyVe();

        String input = "VE001\nVN123\nKH001\n2500000\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        qlv.addVe(scanner);

        if (qlv.getDanhSachVe().size() == 1) {
            System.out.println("===== Test: Thêm Vé =====");
            System.out.println(">> Thêm vé thành công!");
            System.out.println("=== Hiển thị thông tin vé ===");
            qlv.showVe();
        } else {
            System.out.println(" >> Thêm vé thất bại!");
        }
    }

    public static void main(String[] args) {
        testAddVe();
    }
}
