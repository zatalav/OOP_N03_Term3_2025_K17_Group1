package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Service.VeService;
import com.example.servingwebcontent.module.Ve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VeController {

    @Autowired
    private VeService veService;

    // Hiển thị danh sách vé
    @GetMapping("/admin/ticketDetails")
    public String hienThiDanhSachVe(Model model) {
        List<Ve> dsVe = veService.getAll();
        model.addAttribute("dsVe", dsVe);
        return "Admin/ticketDetails";
    }

    // Hiển thị form thêm vé
    @GetMapping("/admin/ticketadd")
    public String hienThiFormThemVe(Model model) {
        model.addAttribute("ve", new Ve());
        return "Admin/ticketadd";
    }

    // Xử lý thêm vé
    @PostMapping("/admin/ticketadd")
    public String xuLyThemVe(@ModelAttribute Ve ve, Model model) {
        if (!veService.isExistMaChuyenBay(ve.getMaChuyenBay())) {
            model.addAttribute("error", "Mã chuyến bay không tồn tại!");
            model.addAttribute("ve", ve);
            return "Admin/ticketadd";
        }
        if (!veService.isExistMaKhachHang(ve.getMaKhachHang())) {
            model.addAttribute("error", "Mã khách hàng không tồn tại!");
            model.addAttribute("ve", ve);
            return "Admin/ticketadd";
        }
        boolean result = veService.add(ve);
        if (result) {
            model.addAttribute("message", "✅ Thêm vé thành công.");
            model.addAttribute("ve", new Ve());
        } else {
            model.addAttribute("error", "❌ Thêm vé thất bại.");
            model.addAttribute("ve", ve);
        }
        return "Admin/ticketadd";
    }

    // Hiển thị form sửa vé
    @GetMapping("/admin/ticketedit")
    public String hienThiFormSuaVe(@RequestParam(required = false) String maVe, Model model) {
        if (maVe != null) {
            Ve ve = veService.getById(maVe);
            model.addAttribute("ve", ve);
            model.addAttribute("maVe", maVe);
        }
        return "Admin/ticketedit";
    }

    // Xử lý cập nhật vé
    @PostMapping("/admin/ticketedit")
    public String xuLySuaVe(@RequestParam String maVe, @ModelAttribute Ve veMoi, Model model) {
        boolean result = veService.update(maVe, veMoi);
        if (result) {
            model.addAttribute("message", "✅ Sửa vé thành công.");
        } else {
            model.addAttribute("error", "❌ Sửa vé thất bại.");
        }
        model.addAttribute("ve", veService.getById(maVe));
        model.addAttribute("maVe", maVe);
        return "Admin/ticketedit";
    }

    // Hiển thị form tìm kiếm vé
    @GetMapping("/admin/ticketfind")
    public String hienThiFormTimVe(@RequestParam(required = false) String maVe, Model model) {
        if (maVe != null) {
            List<Ve> ds = veService.search(maVe);
            if (!ds.isEmpty()) {
                model.addAttribute("ve", ds.get(0));
            } else {
                model.addAttribute("error", "Không tìm thấy vé với mã: " + maVe);
            }
            model.addAttribute("maVe", maVe);
        }
        return "Admin/ticketfind";
    }

    // Hiển thị form xác nhận xóa vé
    @GetMapping("/admin/ticketdelete")
    public String hienThiFormXoa(@RequestParam(required = false) String maVe, Model model) {
        if (maVe != null) {
            Ve ve = veService.getById(maVe);
            if (ve != null) {
                model.addAttribute("ve", ve);
            } else {
                model.addAttribute("notFound", "Không tìm thấy vé với mã: " + maVe);
            }
            model.addAttribute("maVe", maVe);
        }
        return "Admin/ticketdelete";
    }

    // Xử lý xóa vé
    @PostMapping("/admin/ticketdelete")
    public String xuLyXoa(@RequestParam String maVe, Model model) {
        Ve ve = veService.getById(maVe);
        if (ve == null) {
            model.addAttribute("notFound", "Không tìm thấy vé với mã: " + maVe);
            model.addAttribute("maVe", maVe);
            return "Admin/ticketdelete";
        }
        veService.delete(maVe);
        model.addAttribute("message", "✅ Xóa vé thành công.");
        model.addAttribute("dsVe", veService.getAll());
        return "Admin/ticketDetails";
    }
}