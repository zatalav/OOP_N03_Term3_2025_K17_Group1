package src.controller.qlve;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import src.controller.QuanLyChuyenBay;
import src.model.ChuyenBay;

public class InputHelper {

    public static String nhapTen(Scanner sc) {
        System.out.print("Nhập tên hành khách: ");
        return sc.nextLine();
    }

    public static Date nhapNgay(Scanner sc) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        while (true) {
            System.out.print("Nhập ngày đặt vé (dd/MM/yyyy): ");
            try {
                return sdf.parse(sc.nextLine());
            } catch (ParseException e) {
                System.out.println("Ngày không hợp lệ. Nhập lại.");
            }
        }
    }

    public static double nhapGiaGoc(Scanner sc) {
        while (true) {
            System.out.print("Nhập giá gốc mỗi ghế: ");
            try {
                double gia = Double.parseDouble(sc.nextLine());
                if (gia >= 0)
                    return gia;
                System.out.println("Giá phải >= 0.");
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng.");
            }
        }
    }

    public static int nhapSoLuongGhe(Scanner sc) {
        while (true) {
            System.out.print("Nhập số lượng ghế: ");
            try {
                int sl = Integer.parseInt(sc.nextLine());
                if (sl > 0)
                    return sl;
                System.out.println("Số lượng phải > 0.");
            } catch (NumberFormatException e) {
                System.out.println("Nhập số nguyên.");
            }
        }
    }

    public static ChuyenBay nhapChuyenBay(Scanner sc, QuanLyChuyenBay ql) {
        while (true) {
            System.out.print("Nhập mã chuyến bay: ");
            String maCB = sc.nextLine();
            ChuyenBay cb = ql.timTheoMa(maCB);
            if (cb != null)
                return cb;
            System.out.println("Không tìm thấy chuyến bay.");
        }
    }
}
