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

    public void loadFromDatabase() {
    ds.clear();
    dataQuanLyKhachHang dao = new dataQuanLyKhachHang();
    ArrayList<KhachHang> danhSach = dao.selectAll();
    ds.addAll(danhSach);
}

     public void xoa(){
        KhachHang cbxoa = null;
        System.out.println("Nhap ma chuyen bay: ");
        String maKhachHang = sc.nextLine();
        for (KhachHang cb : ds) {
            if (cb.getMaKhachHang().equals(maKhachHang)) {
                cbxoa = cb;
                break;
            }
        }
             if (cbxoa != null) {
                ds.remove(cbxoa);
                dataQuanLyKhachHang dao = new dataQuanLyKhachHang();
                dao.delete(cbxoa); // truyền đối tượng ChuyenBay
                System.out.println("Đã xóa chuyến bay có mã: " + maKhachHang);
                } else {
                    System.out.println("Không tìm thấy chuyến bay với mã: " + maKhachHang);
                }
        }
}
