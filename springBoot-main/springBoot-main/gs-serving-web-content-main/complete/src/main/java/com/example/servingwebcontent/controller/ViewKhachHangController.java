package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.Service.KhachHangService;
import com.example.servingwebcontent.module.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ViewKhachHangController {

    @Autowired
    private KhachHangService service;

    // Hiển thị toàn bộ khách hàng
    @GetMapping("/admin/CustomersDetails")
    public String hienThiDanhSach(Model model) {
        List<KhachHang> ds = service.getAll();
        model.addAttribute("khachList", ds);
        return "Admin/CustomersDetails";
    }

    // Hiển thị form thêm khách hàng
    @GetMapping("/admin/Customeradd")
    public String hienThiFormThem(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        return "Admin/Customeradd";
    }

    // Xử lý thêm khách hàng (POST)
    @PostMapping("/admin/Customeradd")
    public String xuLyThem(@ModelAttribute KhachHang kh, Model model) {
        String phoneRegex = "^\\+\\d{2}\\d{9}$";
        if (!kh.getSoDienThoai().matches(phoneRegex)) {
            model.addAttribute("error", "Số điện thoại phải có dạng +[mã quốc gia][9 số]. VD: +84912345678");
            model.addAttribute("khachHang", kh);
            return "Admin/Customeradd";
        }
        if (service.getById(kh.getMaKhachHang()) != null) {
            model.addAttribute("error", "❌ Thêm khách hàng thất bại. Mã đã tồn tại!");
        } else {
            int result = service.add(kh);
            if (result > 0) {
                model.addAttribute("message", "✅ Thêm khách hàng thành công.");
            } else {
                model.addAttribute("error", "❌ Thêm khách hàng thất bại.");
            }
        }
        model.addAttribute("khachHang", new KhachHang());
        return "Admin/Customeradd";
    }

    // Hiển thị form sửa khách hàng (GET)
    @GetMapping("/admin/Customeredit")
    public String hienThiFormSua(@RequestParam(required = false) String maKhachHang, Model model) {
        if (maKhachHang != null) {
            KhachHang kh = service.getById(maKhachHang);
            model.addAttribute("khachHang", kh);
            model.addAttribute("maKhachHangCu", maKhachHang); // giữ mã cũ để POST dùng
            model.addAttribute("maKhachHang", maKhachHang);
            if (kh == null) {
                model.addAttribute("error", "Không tìm thấy khách hàng với mã: " + maKhachHang);
            }
        }
        return "Admin/Customeredit";
    }

    // Xử lý cập nhật khách hàng (POST)
    @PostMapping("/admin/Customeredit")
    public String xuLySua(@RequestParam("maKhachHangCu") String maCu,
            @ModelAttribute("khachHang") KhachHang khachHang,
            Model model) {
        String phoneRegex = "^\\+\\d{2}\\d{9}$";
        if (!khachHang.getSoDienThoai().matches(phoneRegex)) {
            model.addAttribute("error", "Số điện thoại phải có dạng +[mã quốc gia][9 số]. VD: +84912345678");
            model.addAttribute("khachHang", khachHang);
            model.addAttribute("maKhachHangCu", maCu);
            return "Admin/Customeredit";
        }
        int result = service.update(khachHang); // chỉ truyền khachHang vì service chỉ nhận 1 tham số
        if (result > 0) {
            model.addAttribute("message", "✅ Sửa khách hàng thành công.");
        } else {
            model.addAttribute("error", "❌ Sửa khách hàng thất bại.");
        }
        model.addAttribute("khachHang", khachHang);
        model.addAttribute("maKhachHangCu", maCu);
        return "Admin/Customeredit";
    }

    // Hiển thị form tìm kiếm khách hàng
    @GetMapping("/admin/Customerfind")
    public String hienThiFormTimKiem(@RequestParam(required = false) String maKhachHang, Model model) {
        if (maKhachHang != null) {
            List<KhachHang> ds = service.search(maKhachHang);
            if (!ds.isEmpty()) {
                model.addAttribute("khachHang", ds.get(0));
            } else {
                model.addAttribute("error", "Không tìm thấy khách hàng với mã: " + maKhachHang);
            }
            model.addAttribute("maKhachHang", maKhachHang);
        }
        return "Admin/Customerfind";
    }

    // Hiển thị form xóa khách hàng
    @GetMapping("/admin/Customerdelete")
    public String hienThiFormXoa(@RequestParam(required = false) String maKhachHang, Model model) {
        if (maKhachHang != null) {
            KhachHang kh = service.getById(maKhachHang);
            model.addAttribute("khachHang", kh);
            model.addAttribute("maKhachHang", maKhachHang);
            if (kh == null) {
                model.addAttribute("error", "Không tìm thấy khách hàng với mã: " + maKhachHang);
            }
        }
        return "Admin/Customerdelete";
    }

    // Xử lý xóa khách hàng (POST)
    @PostMapping("/admin/Customerdelete")
    public String xuLyXoa(@RequestParam String maKhachHang, Model model) {
        KhachHang kh = service.getById(maKhachHang);
        if (kh == null) {
            model.addAttribute("error", "Không tìm thấy khách hàng với mã: " + maKhachHang);
            model.addAttribute("maKhachHang", maKhachHang);
            return "Admin/Customerdelete";
        }
        service.delete(maKhachHang);
        model.addAttribute("message", "✅ Xóa khách hàng thành công.");
        List<KhachHang> ds = service.getAll();
        model.addAttribute("khachList", ds);
        return "Admin/CustomersDetails";
    }
}