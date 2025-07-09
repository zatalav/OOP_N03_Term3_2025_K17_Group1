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

    // ✅ Trả về danh sách doanh thu theo từng tháng/năm (không cần truyền tham số)
    public List<ThongKeDoanhThu> layTatCaThongKe() {
        return thongKeDoanhThuAiven.getThongKeTongTheoThangNam();
    }
}
