package com.example.servingwebcontent.Controller.user;

import com.example.servingwebcontent.Service.ChuyenBayService;
import com.example.servingwebcontent.module.ChuyenBay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/chuyenbay")
public class UserChuyenBayController {

    @Autowired
    private ChuyenBayService chuyenBayService;

    // --- Lấy tất cả chuyến bay ---
    @GetMapping("/danhsach")
    public List<ChuyenBay> layTatCaChuyenBay() {
        return chuyenBayService.getAll();
    }

    // --- Tìm chuyến bay theo mã ---
    @GetMapping("/timkiem/{ma}")
    public ResponseEntity<?> timChuyenBay(@PathVariable String ma) {
        List<ChuyenBay> ds = chuyenBayService.search(ma);
        if (ds.isEmpty()) {
            return ResponseEntity.status(404).body("Không tìm thấy chuyến bay có mã: " + ma);
        }
        return ResponseEntity.ok(ds);
    }
}
