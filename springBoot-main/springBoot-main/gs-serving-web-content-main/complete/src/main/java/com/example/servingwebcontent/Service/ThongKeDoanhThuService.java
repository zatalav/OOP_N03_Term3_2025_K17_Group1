package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.database.ThongKeDoanhThuAiven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThongKeDoanhThuService {

    @Autowired
    private ThongKeDoanhThuAiven thongKeDB;

    public double layDoanhThuTheoThangNam(int thang, int nam) {
        return thongKeDB.getDoanhThuTheoThangNam(thang, nam);
    }
}
