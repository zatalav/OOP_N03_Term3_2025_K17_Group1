package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.database.ThongKeDoanhThuAiven;
import com.example.servingwebcontent.documents.WriteToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThongKeDoanhThuService {

    @Autowired
    private ThongKeDoanhThuAiven thongKeDB;

    public double layDoanhThuTheoThangNam(int thang, int nam) {
        double doanhThu = thongKeDB.getDoanhThuTheoThangNam(thang, nam);

        WriteToFile writeToFile = new WriteToFile();
        // Ghi ra file
        writeToFile.writeDoanhThuToFile(thang, nam, doanhThu);

        return doanhThu; // ✅ thiếu dòng này gây lỗi compile
    }
}
