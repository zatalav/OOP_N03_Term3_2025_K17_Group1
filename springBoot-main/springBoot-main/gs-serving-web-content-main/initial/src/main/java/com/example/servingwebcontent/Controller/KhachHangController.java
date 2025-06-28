package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.module.KhachHang;
import com.example.servingwebcontent.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangService service;

    private final String PHONE_REGEX = "^\\+[0-9]{9,14}$";
    private final String MA_REGEX = "^CB\\d{3}_KH\\d{3}$";

    @GetMapping("/hienthitatcakhachhang")
    public List<KhachHang> getAll() {
        return service.getAll();
    }

    @PostMapping("/themkhachhang")
    public ResponseEntity<String> add(@RequestBody KhachHang kh) {
        if (kh.getMaKhachHang() == null || !kh.getMaKhachHang().matches(MA_REGEX)) {
            return ResponseEntity.badRequest().body("Mã khách hàng sai định dạng (VD: CB001_KH123)");
        }
        if (kh.getSoDienThoai() == null || !kh.getSoDienThoai().matches(PHONE_REGEX)) {
            return ResponseEntity.badRequest().body("Số điện thoại sai định dạng (VD: +84345782790)");
        }
        if (service.search(kh.getMaKhachHang()).size() > 0) {
            return ResponseEntity.badRequest().body("Mã khách hàng đã tồn tại");
        }
        service.add(kh);
        return ResponseEntity.ok("Đã thêm khách hàng");
    }

    @PutMapping("/suakhachhang/{ma}")
    public ResponseEntity<String> update(@PathVariable String ma, @RequestBody KhachHang kh) {
        KhachHang existing = service.getById(ma);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        if (kh.getSoDienThoai() == null || !kh.getSoDienThoai().matches(PHONE_REGEX)) {
            return ResponseEntity.badRequest().body("Số điện thoại sai định dạng");
        }
        kh.setMaKhachHang(ma);
        service.update(kh);
        return ResponseEntity.ok("Đã cập nhật khách hàng");
    }

    @DeleteMapping("xoakhachhang/{ma}")
    public ResponseEntity<String> delete(@PathVariable String ma) {
        KhachHang existing = service.getById(ma);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(ma);
        return ResponseEntity.ok("Đã xóa khách hàng có mã: " + ma);
    }

    @GetMapping("/timkhachhang/{ma}")
    public ResponseEntity<List<KhachHang>> search(@PathVariable String ma) {
        List<KhachHang> result = service.search(ma);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}
