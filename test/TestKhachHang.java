import java.io.*;

public class TestKhachHang {
    public static void main(String[] args) {
        try {
            // Gán dữ liệu mẫu
            Ma_khach_hang ma = new Ma_khach_hang("KH001");
            Ho_ten ten = new Ho_ten("Chu Văn An");
            Lien_lac lien_lac = new Lien_lac("chuvanan@gmail.com", "0123456789");

            // Tạo đối tượng KhachHang
            KhachHang khach = new KhachHang(ma, ten, lien_lac);

            // Ghi ra file
            FileOutputStream fos = new FileOutputStream("khachhang.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(khach);
            oos.close();
            fos.close();
            System.out.println("✅ Đã ghi khách hàng vào file khachhang.dat\n");

            // Đọc lại từ file
            FileInputStream fis = new FileInputStream("khachhang.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            KhachHang khachDoc = (KhachHang) ois.readObject();
            ois.close();
            fis.close();

            // In thông tin khách hàng
            System.out.println("== THÔNG TIN KHÁCH HÀNG ĐƯỢC ĐỌC TỪ FILE ==");
            khachDoc.in_thong_tin_khach_hang();

        } catch (Exception e) {
            System.out.println("❌ Lỗi: " + e.getMessage());
        }
    }
}
