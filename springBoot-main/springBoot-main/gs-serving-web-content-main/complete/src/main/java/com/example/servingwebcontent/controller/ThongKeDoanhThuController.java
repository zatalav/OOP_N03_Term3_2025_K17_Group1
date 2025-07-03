package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Service.ThongKeDoanhThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

        double doanhThu = thongKeService.layDoanhThuTheoThangNam(currentMonth, currentYear);

        model.addAttribute("revenueMonth", currentMonth);
        model.addAttribute("revenueYear", currentYear);
        model.addAttribute("revenueTotal", doanhThu);

        return "Admin/revenue"; // Tương ứng templates/Admin/revenue.html
    }
}
