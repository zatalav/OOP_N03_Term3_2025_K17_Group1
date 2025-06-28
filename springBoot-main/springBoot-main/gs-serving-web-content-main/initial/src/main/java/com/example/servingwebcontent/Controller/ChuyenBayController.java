package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Service.ChuyenBayService;
import com.example.servingwebcontent.module.ChuyenBay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chuyenbay")
public class ChuyenBayController {

    @Autowired
    private ChuyenBayService chuyenBayService;

    // --- Thêm chuyến bay ---
    @PostMapping("/themchuyenbay")
    public ResponseEntity<String> themChuyenBay(@RequestBody ChuyenBay cb) {
        if (!cb.getMaChuyenBay().matches("^CB\\d{3}$")) {
            return ResponseEntity.badRequest().body("Sai định dạng mã chuyến bay. (VD: CB001)");
        }

        if (cb.getSoLuongGhe() <= 0) {
            return ResponseEntity.badRequest().body("Số lượng ghế phải lớn hơn 0.");
        }

        if (cb.getGiaVe() <= 0) {
            return ResponseEntity.badRequest().body("Giá vé phải lớn hơn 0.");
        }

        if (!(cb.getNoiQuoc().equalsIgnoreCase("Quoc te") || cb.getNoiQuoc().equalsIgnoreCase("Trong nuoc"))) {
            return ResponseEntity.badRequest().body("Nơi quốc chỉ được là 'Quoc te' hoặc 'Trong nuoc'.");
        }

        chuyenBayService.add(cb);
        return ResponseEntity.ok("Thêm chuyến bay thành công.");
    }

    // --- Lấy tất cả chuyến bay ---
    @GetMapping("/hienthitatcachuyenbay")
    public List<ChuyenBay> layTatCaChuyenBay() {
        return chuyenBayService.getAll();
    }

    // --- Tìm chuyến bay theo mã ---
    @GetMapping("/timchuyenbay/{ma}")
    public ResponseEntity<?> timChuyenBay(@PathVariable String ma) {
        List<ChuyenBay> ds = chuyenBayService.search(ma);
        if (ds.isEmpty()) {
            return ResponseEntity.status(404).body("Không tìm thấy chuyến bay với mã: " + ma);
        }
        return ResponseEntity.ok(ds);
    }

    // --- Sửa chuyến bay ---
    @PutMapping("/suachuyenbay/{ma}")
    public ResponseEntity<String> suaChuyenBay(@PathVariable String ma, @RequestBody ChuyenBay cb) {
        if (cb.getSoLuongGhe() <= 0) {
            return ResponseEntity.badRequest().body("Số lượng ghế phải lớn hơn 0.");
        }

        if (cb.getGiaVe() <= 0) {
            return ResponseEntity.badRequest().body("Giá vé phải lớn hơn 0.");
        }

        if (!(cb.getNoiQuoc().equalsIgnoreCase("Quoc te") || cb.getNoiQuoc().equalsIgnoreCase("Trong nuoc"))) {
            return ResponseEntity.badRequest().body("Nơi quốc chỉ được là 'Quoc te' hoặc 'Trong nuoc'.");
        }

        chuyenBayService.update(ma, cb);
        return ResponseEntity.ok("Đã cập nhật chuyến bay có mã: " + ma);
    }

    // --- Xóa chuyến bay ---
    @DeleteMapping("/xoachuyenbay/{ma}")
    public ResponseEntity<String> xoaChuyenBay(@PathVariable String ma) {
        chuyenBayService.delete(ma);
        return ResponseEntity.ok("Đã xóa chuyến bay có mã: " + ma);
    }
}
