package src;
import java.io.*;
import java.util.Scanner;


class Ma_khach_hang implements Serializable {
    private String ma;

    public Ma_khach_hang(String ma) {
        if (ma == null || ma.isEmpty()) {
            throw new IllegalArgumentException("Ma khach hang khong duoc de trong.");
        }
        this.ma = ma;
    }

    public String toString() {
        return ma;
    }
}


class Ho_ten implements Serializable {
    private String ho_ten;

    public Ho_ten(String ho_ten) {
        if (ho_ten == null || ho_ten.isEmpty()) {
            throw new IllegalArgumentException("Ho ten khong duoc de trong.");
        }
        this.ho_ten = ho_ten;
    }

    public String toString() {
        return ho_ten;
    }
}

class Lien_lac implements Serializable {
    private String email;
    private String so_dien_thoai;

    public Lien_lac(String email, String so_dien_thoai) {
        if (email == null || email.isEmpty() || so_dien_thoai == null || so_dien_thoai.isEmpty()) {
            throw new IllegalArgumentException("Email va so dien thoai khong duoc de trong.");
        }
        this.email = email;
        this.so_dien_thoai = so_dien_thoai;
    }

    public String toString() {
        return "Email: " + email + ", So dien thoai: " + so_dien_thoai;
    }
}


public class KhachHang implements Serializable {
    private static final long serialVersionUID = 1L;

    private Ma_khach_hang ma_khach_hang;
    private Ho_ten ho_ten;
    private Lien_lac lien_lac;

    public KhachHang(Ma_khach_hang ma, Ho_ten ten, Lien_lac lien_lac) {
        this.ma_khach_hang = ma;
        this.ho_ten = ten;
        this.lien_lac = lien_lac;
    }

    public void in_thong_tin_khach_hang() {
        System.out.println("===== THONG TIN KHACH HANG =====");
        System.out.println("Ma khach hang : " + ma_khach_hang);
        System.out.println("Ho va ten     : " + ho_ten);
        System.out.println("Lien lac      : " + lien_lac);
        System.out.println("================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
          
            System.out.print("Nhap ma khach hang: ");
            Ma_khach_hang ma = new Ma_khach_hang(sc.nextLine());

            System.out.print("Nhap ho va ten: ");
            Ho_ten ten = new Ho_ten(sc.nextLine());

            System.out.print("Nhap email: ");
            String email = sc.nextLine();

            System.out.print("Nhap so dien thoai: ");
            String sdt = sc.nextLine();

            Lien_lac lien_lac = new Lien_lac(email, sdt);

            KhachHang khach = new KhachHang(ma, ten, lien_lac);

      
            FileOutputStream fos = new FileOutputStream("khachhang.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(khach);
            oos.close();
            fos.close();

            System.out.println("\nDa luu thong tin vao file khachhang.dat\n");

       
            FileInputStream fis = new FileInputStream("khachhang.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            KhachHang khach_doc = (KhachHang) ois.readObject();
            ois.close();
            fis.close();

            khach_doc.in_thong_tin_khach_hang();

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }

        sc.close();
    }
}