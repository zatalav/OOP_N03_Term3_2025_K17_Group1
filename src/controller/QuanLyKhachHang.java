package src.controller;

import src.database.dataQuanLyKhachHang;
import src.model.KhachHang;
import java.util.ArrayList;


public class QuanLyKhachHang extends manager<KhachHang> {
    public KhachHang nhap(){
        String maKhachHang;
        while(true){
            System.out.println("Nhập mã khách hàng:");
            maKhachHang = sc.nextLine();
            if(kiemTraMaTrung(maKhachHang)){
                System.out.println("Mã khách hàng đã tồn tại, vui lòng nhập lại.");
            } else {
                break;
            }
        }
        System.out.println("Nhập tên khách hàng: ");
        String hoTen = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String soDienThoai = sc.nextLine();
        System.out.println("Nhập căn cước công dân: ");
        String canCuocCongDan = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String diaChi = sc.nextLine();
        
        return new KhachHang(maKhachHang, hoTen,email, soDienThoai,canCuocCongDan, diaChi);
    }
    
    public void them(){
        KhachHang kh = nhap();
        ds.add(kh);  
        // Lưu vào MySQL
        dataQuanLyKhachHang dao = new dataQuanLyKhachHang();
        dao.insert(kh);
    }
}
