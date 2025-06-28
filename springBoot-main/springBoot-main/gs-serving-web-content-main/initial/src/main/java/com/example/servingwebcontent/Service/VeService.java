package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.database.ChuyenBayAiven;
import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.database.VeAiven;
import com.example.servingwebcontent.module.ChuyenBay;
import com.example.servingwebcontent.module.Ve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeService {

    @Autowired
    private VeAiven veDB;

    @Autowired
    private ChuyenBayAiven chuyenBayDB;

    @Autowired
    private KhachHangAiven khachHangDB;

    public List<Ve> getAll() {
        return veDB.selectAll();
    }

    public Ve getById(String maVe) {
        return veDB.selectById(maVe);
    }

    public List<Ve> search(String maVe) {
        return veDB.selectByCondition(maVe);
    }

    public boolean isExistMaChuyenBay(String maCB) {
        return chuyenBayDB.selectById(maCB) != null;
    }

    public boolean isExistMaKhachHang(String maKH) {
        return khachHangDB.selectById(maKH) != null;
    }

    public void add(Ve ve) {
        ve.setMaVe(generateRandomMaVe());

        ChuyenBay cb = chuyenBayDB.selectById(ve.getMaChuyenBay());
        if (cb == null)
            return; // hoặc throw exception

        ve.setThoiGianBay(cb.getThoiGianBay());

        String loai = ve.getloaive();
        String noiQuoc = cb.getNoiQuoc();

        if (noiQuoc.equalsIgnoreCase("Trong nuoc")) {
            if (loai.equals("Thuong")) {
                ve.setGiaVe(cb.getGiaVe() * 1.1); // +10% VAT
            } else if (loai.equals("Vip")) {
                ve.setGiaVe(cb.getGiaVeVip() * 1.1); // +10% VAT
            } else {
                ve.setGiaVe(0); // Không cho phép Hạng Nhất
            }
            ve.setGiaVeHangNhat(0); // Không dùng
        } else if (noiQuoc.equalsIgnoreCase("Quoc te")) {
            if (loai.equals("Thuong")) {
                ve.setGiaVe(cb.getGiaVe());
            } else if (loai.equals("Vip")) {
                ve.setGiaVe(cb.getGiaVeVip());
            } else if (loai.equals("HangNhat")) {
                ve.setGiaVe(cb.getGiaVeHangNhat());
            } else {
                ve.setGiaVe(0); // fallback
            }
        }

        // Lưu thêm để hiển thị nếu muốn
        ve.setGiaVeVip(cb.getGiaVeVip());
        ve.setGiaVeHangNhat(cb.getGiaVeHangNhat());

        veDB.insert(ve);
    }

    public void update(String maVe, Ve veMoi) {
        veMoi.setMaVe(maVe); // Gán lại mã cũ để update đúng

        // Lấy thông tin chuyến bay cập nhật lại giá và thời gian
        ChuyenBay cb = chuyenBayDB.selectById(veMoi.getMaChuyenBay());
        if (cb != null) {
            veMoi.setGiaVe(cb.getGiaVe());
            veMoi.setGiaVeVip(cb.getGiaVeVip());
            veMoi.setGiaVeHangNhat(cb.getGiaVeHangNhat());
            veMoi.setThoiGianBay(cb.getThoiGianBay());
        }

        veDB.update(veMoi);
    }

    public void delete(String maVe) {
        veDB.delete(maVe);
    }

    // Hàm random mã vé tự động (VD: VAB123)
    private String generateRandomMaVe() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        StringBuilder maVe = new StringBuilder("V");

        for (int i = 0; i < 2; i++) {
            int idx = (int) (Math.random() * letters.length());
            maVe.append(letters.charAt(idx));
        }

        for (int i = 0; i < 3; i++) {
            int idx = (int) (Math.random() * digits.length());
            maVe.append(digits.charAt(idx));
        }

        return maVe.toString(); // Ví dụ: VAB123
    }
}
