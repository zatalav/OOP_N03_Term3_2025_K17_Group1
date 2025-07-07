package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.database.ThongKeDoanhThuAiven;
import com.example.servingwebcontent.module.ThongKeDoanhThu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThongKeDoanhThuService {

    @Autowired
    private ThongKeDoanhThuAiven thongKeDoanhThuAiven;

    public List<ThongKeDoanhThu> layDanhSachDoanhThuTheoThangNam(int thang, int nam) {
        return thongKeDoanhThuAiven.getThongKeTheoThangNam(thang, nam);
    }

    public List<ThongKeDoanhThu> layThongKeChiTietTheoThangNam(int thang, int nam) {
        return thongKeDoanhThuAiven.getThongKeTheoThangNam(thang, nam);
    }
}
