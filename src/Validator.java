package src;

import java.util.Scanner;

public class Validator {
    public static boolean laMaVeHopLe(String maVe) {
        return maVe.matches("^[A-Z]{2}\\d{5}$");
    }

    public static String nhapMaVe(Scanner sc) {
        String ma;
        while (true) {
            System.out.print("Nhập mã vé (VD: VE12345): ");
            ma = sc.nextLine();
            if (laMaVeHopLe(ma))
                break;
            System.out.println("❌ Mã không hợp lệ. Nhập lại.");
        }
        return ma;
    }
}
