package src;

import java.util.Scanner;

public class QuanLyKhachHang {
    private EditKhachHang edit = new EditKhachHang();

    public void addKhachHang(Scanner sc) {
        edit.addKhachHang(sc);
    }

    public void editKhachHang(Scanner sc) {
        edit.editKhachHang(sc);
    }

    public void deleteKhachHang(Scanner sc) {
        edit.deleteKhachHang(sc);
    }

    public void showKhachHang() {
        edit.showKhachHang();
    }
}
