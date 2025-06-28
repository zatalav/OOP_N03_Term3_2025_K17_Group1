package com.example.servingwebcontent.Controller.user;

import com.example.servingwebcontent.Service.VeService;
import com.example.servingwebcontent.module.Ve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/ve")
public class UserVeController {

    @Autowired
    private VeService veService;

    // --- Thêm vé ---
    @PostMapping("/themve")
    public ResponseEntity<String> themVe(@RequestBody Ve ve) {
        if (!veService.isExistMaChuyenBay(ve.getMaChuyenBay())) {
            return ResponseEntity.badRequest().body("Mã chuyến bay không tồn tại.");
        }

        if (!veService.isExistMaKhachHang(ve.getMaKhachHang())) {
            return ResponseEntity.badRequest().body("Mã khách hàng không tồn tại.");
        }

        if (!(ve.getloaive().equals("Thuong") || ve.getloaive().equals("Vip") || ve.getloaive().equals("HangNhat"))) {
            return ResponseEntity.badRequest().body("Loại vé phải là 'Thuong', 'Vip' hoặc 'HangNhat'.");
        }

        veService.add(ve);
        return ResponseEntity.ok("Đặt vé thành công.");
    }

    // --- Xóa vé ---
    @DeleteMapping("/xoave/{ma}")
    public ResponseEntity<String> xoaVe(@PathVariable String ma) {
        veService.delete(ma);
        return ResponseEntity.ok("Đã hủy vé có mã: " + ma);
    }
}
