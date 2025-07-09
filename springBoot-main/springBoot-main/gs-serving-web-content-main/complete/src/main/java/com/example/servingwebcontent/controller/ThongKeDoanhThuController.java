package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Service.ThongKeDoanhThuService;
import com.example.servingwebcontent.module.ThongKeDoanhThu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/revenue")
public class ThongKeDoanhThuController {

    @Autowired
    private ThongKeDoanhThuService thongKeService;

    @GetMapping("")
    public String hienThiTongDoanhThu(Model model) {
        List<ThongKeDoanhThu> revenueList = thongKeService.layTatCaThongKe(); // ✅ HÀM NÀY

        double tong = revenueList.stream().mapToDouble(ThongKeDoanhThu::getTongTien).sum();

        model.addAttribute("revenueList", revenueList);
        model.addAttribute("revenueTotal", tong);
        return "Admin/revenue"; // ✅ đúng file HTML
    }
}
