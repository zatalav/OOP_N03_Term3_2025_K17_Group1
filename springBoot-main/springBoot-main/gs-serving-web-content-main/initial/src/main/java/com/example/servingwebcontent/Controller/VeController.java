package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Service.VeService;
import com.example.servingwebcontent.module.Ve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ve")
public class VeController {

    @Autowired
    private VeService veService;

    // --- Thêm vé ---
    @PostMapping("/themve")
    public ResponseEntity<String> themVe(@RequestBody Ve ve) {
        // Kiểm tra mã chuyến bay
        if (!veService.isExistMaChuyenBay(ve.getMaChuyenBay())) {
            return ResponseEntity.badRequest().body("Mã chuyến bay không tồn tại.");
        }

        // Kiểm tra mã khách hàng
        if (!veService.isExistMaKhachHang(ve.getMaKhachHang())) {
            return ResponseEntity.badRequest().body("Mã khách hàng không tồn tại.");
        }

        // Kiểm tra loại vé
        if (!(ve.getloaive().equalsIgnoreCase("Thuong") ||
                ve.getloaive().equalsIgnoreCase("Vip") ||
                ve.getloaive().equalsIgnoreCase("HangNhat"))) {
            return ResponseEntity.badRequest().body("Loại vé phải là 'Thuong', 'Vip' hoặc 'HangNhat'.");
        }

        veService.add(ve);
        return ResponseEntity.ok("Thêm vé thành công.");
    }

    // --- Hiển thị tất cả vé ---
    @GetMapping("/hienthitatcave")
    public List<Ve> getAllVe() {
        return veService.getAll();
    }

    // --- Tìm vé theo mã ---
    @GetMapping("/timve/{ma}")
    public ResponseEntity<?> timVe(@PathVariable String ma) {
        List<Ve> ds = veService.search(ma);
        if (ds.isEmpty()) {
            return ResponseEntity.status(404).body("Không tìm thấy vé có mã: " + ma);
        }
        return ResponseEntity.ok(ds);
    }

    // --- Sửa vé ---
    @PutMapping("/suave/{ma}")
    public ResponseEntity<String> suaVe(@PathVariable String ma, @RequestBody Ve ve) {
        if (!veService.isExistMaChuyenBay(ve.getMaChuyenBay())) {
            return ResponseEntity.badRequest().body("Mã chuyến bay không tồn tại.");
        }

        if (!veService.isExistMaKhachHang(ve.getMaKhachHang())) {
            return ResponseEntity.badRequest().body("Mã khách hàng không tồn tại.");
        }

        // Kiểm tra loại vé
        if (!(ve.getloaive().equalsIgnoreCase("Thuong") ||
                ve.getloaive().equalsIgnoreCase("Vip") ||
                ve.getloaive().equalsIgnoreCase("HangNhat"))) {
            return ResponseEntity.badRequest().body("Loại vé phải là 'Thuong', 'Vip' hoặc 'HangNhat'.");
        }

        veService.update(ma, ve);
        return ResponseEntity.ok("Đã cập nhật vé có mã: " + ma);
    }

    // --- Xóa vé ---
    @DeleteMapping("/xoave/{ma}")
    public ResponseEntity<String> xoaVe(@PathVariable String ma) {
        veService.delete(ma);
        return ResponseEntity.ok("Đã xóa vé có mã: " + ma);
    }
}
