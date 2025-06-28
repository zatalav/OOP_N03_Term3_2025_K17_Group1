package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.database.ChuyenBayAiven;
import com.example.servingwebcontent.module.ChuyenBay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenBayService {

    @Autowired
    private ChuyenBayAiven database;

    public List<ChuyenBay> getAll() {
        return database.selectAll();
    }

    public void add(ChuyenBay cb) {
        tinhToanSoGheVaGiaVe(cb);
        database.insert(cb);
    }

    public void update(String maChuyenBay, ChuyenBay cbMoi) {
        cbMoi.setMaChuyenBay(maChuyenBay);
        tinhToanSoGheVaGiaVe(cbMoi);
        database.update(cbMoi);
    }

    public void delete(String maChuyenBay) {
        database.delete(maChuyenBay);
    }

    public ChuyenBay getById(String maChuyenBay) {
        return database.selectById(maChuyenBay);
    }

    public List<ChuyenBay> search(String maChuyenBay) {
        return database.selectByCondition(maChuyenBay);
    }

    private void tinhToanSoGheVaGiaVe(ChuyenBay cb) {
        int tongGhe = cb.getSoLuongGhe();
        int gheVip = tongGhe / 10;
        int gheHangNhat = cb.getNoiQuoc().equalsIgnoreCase("Quoc te") ? tongGhe / 20 : 0;
        int gheThuong = tongGhe - gheVip - gheHangNhat;

        cb.setGheVip(gheVip);
        cb.setGheHangNhat(gheHangNhat);
        cb.setGheThuong(gheThuong);

        // Xử lý giá vé
        double giaVe = cb.getGiaVe();

        if (cb.getNoiQuoc().equalsIgnoreCase("Trong nuoc")) {
            // Quốc nội: +10% VAT, không có hạng nhất
            giaVe = giaVe * 1.1; // +10% VAT
            cb.setGiaVe(giaVe);
            cb.setGiaVeVip(giaVe * 1.5);
            cb.setGiaVeHangNhat(0); // Không có vé hạng nhất
            cb.setGheHangNhat(0);
        } else {
            // Quốc tế: không cộng VAT, đủ 3 loại vé
            cb.setGiaVe(giaVe); // không thay đổi
            cb.setGiaVeVip(giaVe * 1.5);
            cb.setGiaVeHangNhat(giaVe * 3.0);
        }
    }
}
