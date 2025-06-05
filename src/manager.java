package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class manager<M extends Identifiable> {
    protected List<M> ds = new ArrayList<>();
    protected Scanner sc = new Scanner(System.in);
    protected abstract M nhap();
    
    public void show() {
        for(M m : ds) {
            System.out.println(m);
        }
    }

    public void add(){
    System.out.println("Nhap thong tin moi:");
    M m = nhap();
    if (m != null) {
        ds.add(m);
        System.out.println("Da them thanh cong!");
    } else {
        System.out.println("Them that bai!");
    }
}

    public void delete() {
        String ma = sc.nextLine();
        boolean removed = ds.removeIf(m -> m.getMa().equals(ma));
        if (removed) {
            System.out.println("Đã xóa thành công!");
        } else {
            System.out.println("Không tìm thấy mã cần xóa!");
        }
    }

    public void edit() {
        String ma = sc.nextLine();
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMa().equals(ma)) {
                System.out.println("Nhập thông tin mới:");
                M m = nhap();
                if (m != null) {
                    // Kiểm tra mã mới có trùng với mã khác hay không
                    if (!m.getMa().equals(ma) && ds.stream().anyMatch(item -> item.getMa().equals(m.getMa()))) {
                        System.out.println("Mã mới đã tồn tại! Sửa thất bại!");
                        return;
                    }
                    ds.set(i, m);
                    System.out.println("Đã sửa thành công!");
                } else {
                    System.out.println("Sửa thất bại do thông tin không hợp lệ!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy mã cần sửa!");
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