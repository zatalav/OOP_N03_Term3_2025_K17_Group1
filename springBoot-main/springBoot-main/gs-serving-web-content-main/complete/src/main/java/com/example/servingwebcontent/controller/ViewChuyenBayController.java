package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Service.ChuyenBayService;
import com.example.servingwebcontent.module.ChuyenBay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ViewChuyenBayController {

    @Autowired
    private ChuyenBayService chuyenBayService;

    // Hiển thị tất cả chuyến bay
    @GetMapping("/admin/flights")
    public String hienThiTatCa(Model model) {
        List<ChuyenBay> list = chuyenBayService.getAll();
        model.addAttribute("flightList", list);
        return "Admin/flights";
    }

    // Hiển thị form thêm chuyến bay (GET)
    @GetMapping("/admin/flightadd")
    public String hienThiFormThem(Model model) {
        model.addAttribute("chuyenBay", new ChuyenBay());
        return "Admin/flightadd";
    }

    // Xử lý thêm chuyến bay (POST)
    @PostMapping("/admin/flightadd")
    public String themChuyenBay(@ModelAttribute("chuyenBay") ChuyenBay cb, Model model) {
        if (chuyenBayService.getById(cb.getMaChuyenBay()) != null) {
            model.addAttribute("error", "❌ Thêm chuyến bay thất bại. Mã đã tồn tại!");
        } else {
            int result = chuyenBayService.add(cb);
            if (result > 0) {
                model.addAttribute("message", "✅ Thêm chuyến bay thành công.");
            } else {
                model.addAttribute("error", "❌ Thêm chuyến bay thất bại.");
            }
        }
        model.addAttribute("chuyenBay", new ChuyenBay());
        return "Admin/flightadd"; // KHÔNG redirect, tránh lỗi cổng
    }

    // Hiển thị form sửa chuyến bay (GET)
    // ✅ Hiển thị form sửa chuyến bay (GET)
    @GetMapping("/admin/flightedit")
    public String hienThiFormSua(@RequestParam(required = false) String maChuyenBay, Model model) {
        if (maChuyenBay != null) {
            ChuyenBay cb = chuyenBayService.getById(maChuyenBay);
            model.addAttribute("chuyenBay", cb);
            model.addAttribute("maChuyenBayCu", maChuyenBay); // giữ mã cũ để POST dùng
            model.addAttribute("maChuyenBay", maChuyenBay); // luôn truyền sang view
            if (cb == null) {
                model.addAttribute("error", "Không tìm thấy chuyến bay với mã: " + maChuyenBay);
            }
        }
        return "Admin/flightedit";
    }

    // ✅ Xử lý lưu thay đổi chuyến bay (POST)
    @PostMapping("/admin/flightedit")
    public String luuChinhSua(
            @RequestParam("maChuyenBayCu") String maCu,
            @ModelAttribute("chuyenBay") ChuyenBay chuyenBay,
            Model model) {

        int result = chuyenBayService.update(maCu, chuyenBay);
        if (result > 0) {
            model.addAttribute("message", "✅ Sửa chuyến bay thành công.");
        } else {
            model.addAttribute("error", "❌ Sửa chuyến bay thất bại.");
        }
        model.addAttribute("chuyenBay", chuyenBay);
        model.addAttribute("maChuyenBayCu", maCu);
        return "Admin/flightedit";
    }

    // Hiển thị form tìm kiếm chuyến bay
    @GetMapping("/admin/flightfind")
    public String timChuyenBayWeb(@RequestParam(required = false) String maChuyenBay, Model model) {
        if (maChuyenBay != null) {
            List<ChuyenBay> ds = chuyenBayService.search(maChuyenBay);
            if (!ds.isEmpty()) {
                model.addAttribute("chuyenBay", ds.get(0));
            } else {
                model.addAttribute("error", "Không tìm thấy chuyến bay với mã: " + maChuyenBay);
            }
            model.addAttribute("maChuyenBay", maChuyenBay);
        }
        return "Admin/flightfind";
    }

    // Hiển thị form xóa chuyến bay
    @GetMapping("/admin/flightdelete")
    public String hienThiXoaChuyenBay(@RequestParam(required = false) String maChuyenBay, Model model) {
        if (maChuyenBay != null) {
            ChuyenBay cb = chuyenBayService.getById(maChuyenBay);
            model.addAttribute("chuyenBay", cb);
            model.addAttribute("maChuyenBay", maChuyenBay);
            if (cb == null) {
                model.addAttribute("error", "Không tìm thấy chuyến bay với mã: " + maChuyenBay);
            }
        }
        return "Admin/flightdelete";
    }

    // Xử lý xóa chuyến bay (POST)
    @PostMapping("/admin/flightdelete")
    public String xoaChuyenBay(@RequestParam String maChuyenBay, Model model) {
        ChuyenBay cb = chuyenBayService.getById(maChuyenBay);
        if (cb == null) {
            model.addAttribute("error", "Không tìm thấy chuyến bay với mã: " + maChuyenBay);
            model.addAttribute("maChuyenBay", maChuyenBay);
            return "Admin/flightdelete";
        }
        chuyenBayService.delete(maChuyenBay);
        model.addAttribute("message", "✅ Xóa chuyến bay thành công.");
        List<ChuyenBay> list = chuyenBayService.getAll();
        model.addAttribute("flightList", list);
        return "Admin/flights";
    }
}
