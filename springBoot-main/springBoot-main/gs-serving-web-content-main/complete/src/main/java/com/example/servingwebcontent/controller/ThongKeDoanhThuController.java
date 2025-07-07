package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Service.ThongKeDoanhThuService;
import com.example.servingwebcontent.module.ThongKeDoanhThu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin/revenue")
public class ThongKeDoanhThuController {

    @Autowired
    private ThongKeDoanhThuService thongKeService;

    @GetMapping("")
    public String hienThiDoanhThu(Model model,
            @RequestParam(name = "thang", required = false) Integer thang,
            @RequestParam(name = "nam", required = false) Integer nam) {

        LocalDate now = LocalDate.now();
        int currentMonth = (thang != null) ? thang : now.getMonthValue();
        int currentYear = (nam != null) ? nam : now.getYear();

        List<ThongKeDoanhThu> doanhThuList = thongKeService.layThongKeChiTietTheoThangNam(currentMonth, currentYear);

        // ✅ Tính tổng doanh thu: cộng theo từng vé đã bán dựa vào loại vé
        double revenueTotal = doanhThuList.stream().mapToDouble(item -> {
            String loai = item.getLoaive().toLowerCase().replaceAll("\\s+", "");
            if (loai.contains("thuong") || loai.contains("thường"))
                return item.getGiaVe();
            if (loai.contains("vip"))
                return item.getGiaVeVip();
            if (loai.contains("hangnhat") || loai.contains("hạngnhất"))
                return item.getGiaVeHangNhat();
            return 0;
        }).sum();

        model.addAttribute("revenueMonth", currentMonth);
        model.addAttribute("revenueYear", currentYear);
        model.addAttribute("revenueTotal", revenueTotal);

        return "Admin/revenue";
    }
}
