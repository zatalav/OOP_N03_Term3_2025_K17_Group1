import java.util.ArrayList;

import src.model.KhachHang;

public class KhachHangList {

    ArrayList<KhachHang> kh = new ArrayList<>();

    public ArrayList<KhachHang> addKhachHang(KhachHang k) {
        kh.add(k);
        return kh;
    }

    public ArrayList<KhachHang> getEditKhachHang(String hoTenMoi, String maKhachHang) {
        for (int i = 0; i < kh.size(); i++) {
            if (kh.get(i).maKhachHang == maKhachHang) {
                System.out.println("true");
                kh.get(i).hoTen = hoTenMoi;
            }
        }
        return kh;
    }

    public ArrayList<KhachHang> getDeleteKhachHang(String maKhachHang) {
        for (int i = 0; i < kh.size(); i++) {
            if (kh.get(i).maKhachHang == maKhachHang) {
                kh.remove(i);
                break;
            }
        }
        return kh;
    }

    public void printKhachHangList() {
        int len = kh.size();
        for (int i = 0; i < len; i++) {
            System.out.println("Mã KH: " + kh.get(i).maKhachHang + " | Họ tên: " + kh.get(i).hoTen);
        }
    }
}
