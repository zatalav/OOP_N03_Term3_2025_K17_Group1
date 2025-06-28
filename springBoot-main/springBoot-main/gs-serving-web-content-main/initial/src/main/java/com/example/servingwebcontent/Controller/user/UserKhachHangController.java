package com.example.servingwebcontent.Controller.user;

import com.example.servingwebcontent.Service.KhachHangService;
import com.example.servingwebcontent.module.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/khachhang")
public class UserKhachHangController {

    @Autowired
    private KhachHangService service;

    private final String PHONE_REGEX = "^\\+[0-9]{9,14}$";

    // --- Sửa thông tin khách hàng ---
    @PutMapping("/sua")
    public ResponseEntity<String> suaKhachHang(@RequestParam String ma, @RequestBody KhachHang kh) {
        if (!kh.getSoDienThoai().matches(PHONE_REGEX)) {
            return ResponseEntity.badRequest().body("Số điện thoại sai định dạng (VD: +84345782790)");
        }

        kh.setMaKhachHang(ma); // gán lại mã đã được xác thực sẵn
        service.update(kh);
        return ResponseEntity.ok("Đã cập nhật thông tin thành công");
    }

    // --- Xóa tài khoản khách hàng ---
    @DeleteMapping("/xoa")
    public ResponseEntity<String> xoaKhachHang(@RequestParam String ma) {
        service.delete(ma);
        return ResponseEntity.ok("Đã xóa tài khoản, vui lòng đăng nhập lại.");
    }
}
