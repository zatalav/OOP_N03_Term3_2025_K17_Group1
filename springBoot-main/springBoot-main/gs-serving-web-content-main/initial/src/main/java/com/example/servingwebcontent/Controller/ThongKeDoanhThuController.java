package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Service.ThongKeDoanhThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/thongke")
public class ThongKeDoanhThuController {

    @Autowired
    private ThongKeDoanhThuService thongKeService;

    // --- Thống kê doanh thu theo tháng và năm ---
    @GetMapping("/doanhthu")
    public ResponseEntity<?> layDoanhThuTheoThangNam(
            @RequestParam int thang,
            @RequestParam int nam) {

        if (thang < 1 || thang > 12) {
            return ResponseEntity.badRequest().body("Tháng không hợp lệ (1-12).");
        }

        if (nam < 2000 || nam > 2100) {
            return ResponseEntity.badRequest().body("Năm không hợp lệ (2000-2100).");
        }

        double doanhThu = thongKeService.layDoanhThuTheoThangNam(thang, nam);

        return ResponseEntity.ok("✅ Doanh thu tháng " + thang + "/" + nam + ": " + doanhThu + " VND\n"
                + "📄 Đã ghi file: DoanhThu_" + thang + "_" + nam + ".txt trong thư mục ./complete/File/ThongKe/");
    }
}
