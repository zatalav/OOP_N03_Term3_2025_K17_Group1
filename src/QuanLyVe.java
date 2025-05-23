package src;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyVe {
    private ArrayList<Ve> danhSachVe = new ArrayList<>();

    public void addVe(Scanner sc){
        Ve ve = new Ve();
        ve.nhapThongTin();
        danhSachVe.add(ve);
        System.out.println("Đã thêm vé thành công!");
    }

    public void editVe(Scanner sc){
        System.out.print("Nhập mã vé cần sửa: ");
        String maVe = sc.nextLine();
        for (int i = 0; i < danhSachVe.size(); i++) {
            if (danhSachVe.get(i).getMaVe().equals(maVe)) {
                System.out.println("Nhập thông tin mới cho vé:");
                Ve veMoi = new Ve();
                veMoi.nhapThongTin();
                danhSachVe.set(i, veMoi);
                System.out.println("Đã sửa vé thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã vé này!");
    }

    public void deleteVe(Scanner sc){
        System.out.print("Nhập mã vé cần xóa: ");
        String maVe = sc.nextLine();
        for (int i = 0; i < danhSachVe.size(); i++) {
            if (danhSachVe.get(i).getMaVe().equals(maVe)) {
                danhSachVe.remove(i);
                System.out.println("Đã xóa vé thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã vé này!");
    }

    public void showVe(){
        if (danhSachVe.isEmpty()) {
            System.out.println("Danh sách vé rỗng.");
            return;
        }
        for(int i=0; i<danhSachVe.size(); i++){
            System.out.println("Vé số "+(i+1)+":");
            danhSachVe.get(i).hienThiThongTin();
            System.out.println("------------------------------");
        }
    }
}