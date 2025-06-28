package com.example.servingwebcontent.Service;

import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.module.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {

	@Autowired
	private KhachHangAiven database;

	public List<KhachHang> getAll() {
		return database.selectAll();
	}

	public void add(KhachHang khachHang) {
		database.insert(khachHang);
	}

	public void update(KhachHang khachHang) {
		database.update(khachHang);
	}

	public void delete(String maKhachHang) {
		database.delete(maKhachHang);
	}

	public List<KhachHang> search(String maKhachHang) {
		return database.selectByCondition(maKhachHang);
	}

	public KhachHang getById(String maKhachHang) {
		return database.selectById(maKhachHang);
	}

	public KhachHang getByEmail(String email) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getByEmail'");
	}
}
