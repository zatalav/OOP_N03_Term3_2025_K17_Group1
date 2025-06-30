package src.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.model.Identifiable;

public abstract class manager<M extends Identifiable> {
    protected List<M> ds = new ArrayList<>();
    protected Scanner sc = new Scanner(System.in);
    protected abstract M nhap();

    public void add(){
        System.out.println("Nhập thông tin mới:");
        M m = nhap();
        if (m != null) {
           ds.add(m);
        System.out.println("Đã thêm thành công!");
        } else {
            System.out.println("Thêm thất bại!");
        }
    }
    public boolean kiemTraMaTrung(String ma) {
        if (ma == null || ma.trim().isEmpty()) {
            return false; // Không coi mã rỗng hoặc null là trùng
        }
        return ds.stream().anyMatch(item -> item.getMa().equals(ma));
    }

     public void close() {
        if (sc != null) {
            sc.close();
        }
    }

}