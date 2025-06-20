package src.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import src.model.KhachHang;
import src.model.ChuyenBay;
import src.model.Ve;
import src.database.dataQuanLyVe;

public class QuanLyVe extends manager<Ve> {
    pulic String regex = "^CB\\d{3}_V\\d{3}$";
    ArrayList<KhachHang> dsKhachHang = new src.database.dataQuanLyKhachHang().selectAll();
    ArrayList<ChuyenBay> dsChuyenBay = new src.database.dataQuanLyChuyenBay().selectAll();

    Date parseDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Lỗi định dạng ngày tháng: " + e.getMessage());
            return null;
        }
    }

    private boolean kiemTraMaKhachHangTonTai(String maKhachHang, ArrayList<KhachHang> dsKhachHang) {
        for (KhachHang kh : dsKhachHang) {
            if (kh.getMaKhachHang().equals(maKhachHang)) {
                return true;
            }
        }
        return false;
    }

    // Kiểm tra mã chuyến bay có tồn tại trong danh sách chuyến bay không
    private boolean kiemTraMaChuyenBayTonTai(String maChuyenBay, ArrayList<ChuyenBay> dsChuyenBay) {
        for (ChuyenBay cb : dsChuyenBay) {
            if (cb.getMaChuyenBay().equals(maChuyenBay)) {
                return true;
            }
        }
        return false;
    }

    protected Ve nhap() {
        String maVe;
        while (true) {
            System.out.println("Nhập mã vé:");
            maVe = sc.nextLine();
            if (kiemTraMaTrung(maVe)) {
                System.out.println("Mã vé đã tồn tại, vui lòng nhập lại.");
            } else {
                break;
            }
        }
        System.out.println("Nhập mã khách hàng:");
        String maKhachHang = sc.nextLine();
        if (!kiemTraMaKhachHangTonTai(maKhachHang, dsKhachHang)) {
            System.out.println("Mã khách hàng không tồn tại, vui lòng nhập lại.");
            return null; // Hoac co the yeu cau nhap lai ma khach hang
        }
        System.out.println("Nhập mã chuyến bay:");
        String maChuyenBay = sc.nextLine();
        Date ngayDatVe = null;
        if (!kiemTraMaChuyenBayTonTai(maChuyenBay, dsChuyenBay)) {
            System.out.println("Mã chuyến bay không tồn tại, vui lòng nhập lại.");
            return null; // Hoac co the yeu cau nhap lai ma chuyen bay
        }
        do {
            System.out.println("Nhập ngày đặt vé (dd/MM/yyyy hh:mm):");
            String ngayDatVeStr = sc.nextLine();
            ngayDatVe = parseDate(ngayDatVeStr);
        } while (ngayDatVe == null);

        System.out.println("Nhập giá vé:");
        double giaVe = 0;
        while (true) {
            System.out.println("Nhap gia ve:");
            try {
                giaVe = Double.parseDouble(sc.nextLine());
                if (giaVe < 0) {
                    System.out.println("Gia ve phai lon hon 0, vui long nhap lai.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia ve khong hop le, vui long nhap so.");
            }
        }
        int ThoiGianBay = cb.getThoiGianBay();
        // lựa chọn loại vé
        String loaive;
        sc.nextLine();
        if (cb.getNoiquoc().equalsIgnoreCase("Trong nước")) {
            while (true) {
                System.out.print("Nhập loại vé ('V'='VIP ticket'(hạng thương gia)  'E'='Economy ticket(vé thường)'): ");
                String chon = sc.nextLine().toUpperCase();
                if (chon.equals("V")) {
                    loaive = "VIP";
                    break;
                } else if (chon.equals("E")) {
                    loaive = "THUONG";
                    break;
                } else {
                    System.out.println("Loại vé không hợp lệ cho chuyến bay trong nước.");
                }
            }
        } else {
            // Quốc tế → cho cả 3
            while (true) {
                System.out.print(
                        "Nhập loại vé ('F'='First Class ticket(vé hạng nhất)'  'V'='VIP ticket'(hạng thương gia)  'E'='Economy ticket(vé thường)'): ");
                String chon = sc.nextLine().toUpperCase();
                if (chon.equals("V")) {
                    loaive = "VIP";
                    break;
                } else if (chon.equals("E")) {
                    loaive = "THUONG";
                    break;
                } else if (chon.equals("F")) {
                    loaive = "FIRST";
                    break;
                } else {
                    System.out.println("Loại vé không hợp lệ.");
                }
            }
        }

        double giaVeVip = giaVe * 1.5;
        double giaVeHangNhat = giaVe * 3;

        return new Ve(maVe, ngayDatVe, ThoiGianBay, giaVe, giaVeVip, giaVeHangNhat, loaive, maChuyenBay, maKhachHang);
    }

    public void them() {
        Ve v = nhap(); // Nhập chuyến bay từ bàn phím
        ds.add(v); // Thêm vào danh sách tạm thời (RAM)
        // Lưu vào MySQL
        dataQuanLyVe dao = new dataQuanLyVe();
        dao.insert(v);
    }

    public void loadFromDatabase() {
        ds.clear();
        dataQuanLyVe dao = new dataQuanLyVe();
        ArrayList<Ve> danhSach = dao.selectAll();
        ds.addAll(danhSach);
    }
    loadFromDatabase();
        String maVe;
        while (true) {
            System.out.println("Nhap ma ve:");
            maVe = sc.nextLine();
            if(!maVe.matches("^CB\\d{3}_V\\d{3}$")){
                System.out.println("Sai định dạng mã(VD: CB001_V123). Nhập lại:");
            }  
            else if (kiemTraMaTrung(maVe)) {
                System.out.println("Ma ve da ton tai, vui long nhap lai.");
            } else {
                break;
            }
        }

        String maChuyenBay;
        while(true){
            System.out.println("Nhap ma chuyen bay:");
            maChuyenBay = sc.nextLine();
            if (!kiemTraMaChuyenBayTonTai(maChuyenBay, dsChuyenBay)) {
                System.out.println("Ma chuyen bay khong ton tai, vui long nhap lai.");
            }
            else break;
        }

        String maKhachHang;
        while(true){
            System.out.println("Nhap ma khach hang:");
            maKhachHang = sc.nextLine();
            if (!kiemTraMaKhachHangTonTai(maKhachHang, dsKhachHang)) {
                System.out.println("Ma khach hang khong ton tai, vui long nhap lai.");
            }
            else break;
        }

    public void lietKe() {
        dataQuanLyVe dao = new dataQuanLyVe();
        ArrayList<Ve> danhSach = dao.selectAll();
        if (danhSach.isEmpty()) {
            System.out.println("Không có chuyến bay nào trong hệ thống.");
        } else {
            for (Ve v : danhSach) {
                System.out.println(v);
            }
        }
    }

    public void timkiem() {
        System.out.println("Nhập mã vé: ");
        String maVe = sc.nextLine();
        dataQuanLyVe dao = new dataQuanLyVe();
        ArrayList<Ve> ketQua = dao.selectByCondition(maVe);
        if (!ketQua.isEmpty()) {
            for (Ve v : ketQua) {
                System.out.println("Chuyến bay tìm thấy: " + v);
            }
        } else {
            System.out.println("Không tìm thấy chuyến bay với mã: " + maVe);
        }
    }

    public void xoa() {
        Ve vxoa = null;
        System.out.println("Nhập mã Vé: ");
        String maVe = sc.nextLine();
        for (Ve v : ds) {
            if (v.getMaVe().equals(maVe)) {
                vxoa = v;
                break;
            }
        }
        if (vxoa != null) {
            ds.remove(vxoa);
            dataQuanLyVe dao = new dataQuanLyVe();
            dao.delete(vxoa); // truyền đối tượng ChuyenBay
            System.out.println("Đã xóa chuyến bay có mã: " + maVe);
        } else {
            System.out.println("Không tìm thấy chuyến bay với mã: " + maVe);
        }
    }

    public void sua() {
        loadFromDatabase();
        Ve vsua = null;
        System.out.println("Nhập mã Vé: ");
        String maVe = sc.nextLine();
        for (Ve v : ds) {
            if (v.getMaVe().equals(maVe)) {
                vsua = v;
                break;
            }
        }
        if (vsua != null) {
            // Nhập lại thông tin mới cho chuyến bay (trừ mã)
            Date ngayDatVe = null;
            do {
                System.out.println("Nhập ngày đặt vé (dd/MM/yyyy hh:mm):");
                String ngayDatVeStr = sc.nextLine();
                ngayDatVe = parseDate(ngayDatVeStr);
            } while (ngayDatVe == null);
            vsua.setNgayDatVe(ngayDatVe);
        double giaVeMoi;
        while (true){
            System.out.println("Nhap gia ve:");
            try {
                giaVeMoi = Double.parseDouble(sc.nextLine());
                if (giaVeMoi < 0) {
                    System.out.println("Gia ve phai lon hon 0, vui long nhap lai.");
                } else {
                    vsua.setGiaVe(giaVeMoi);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia ve khong hop le, vui long nhap so.");
            }

        }

            String loaive;
            ChuyenBay cb = null;
            for (ChuyenBay c : dsChuyenBay) {
                if (c.getmaChuyenBay().equals(vsua.getMaChuyenBay())) {
                    cb = c;
                    break;
                }
            }
            if (cb == null) {
                System.out.println("Không tìm thấy chuyến bay tương ứng!");
                return;
            }

            vsua.setThoiGianBay(cb.getThoiGianBay());

            if (cb.getNoiquoc().equalsIgnoreCase("Trong nước")) {
                while (true) {
                    System.out.print(
                            "Nhập loại vé ('V'='VIP ticket'(hạng thương gia)  'E'='Economy ticket(vé thường)'): ");
                    String chon = sc.nextLine().toUpperCase();
                    if (chon.equals("V")) {
                        loaive = "VIP";
                        break;
                    } else if (chon.equals("E")) {
                        loaive = "THUONG";
                        break;
                    } else {
                        System.out.println("Loại vé không hợp lệ cho chuyến bay trong nước.");
                    }
                }
            } else {
                while (true) {
                    System.out.print(
                            "Nhập loại vé ('F'='First Class ticket(vé hạng nhất)'  'V'='VIP ticket'(hạng thương gia)  'E'='Economy ticket(vé thường)'): ");
                    String chon = sc.nextLine().toUpperCase();
                    if (chon.equals("V")) {
                        loaive = "VIP";
                        break;
                    } else if (chon.equals("E")) {
                        loaive = "THUONG";
                        break;
                    } else if (chon.equals("F")) {
                        loaive = "FIRST";
                        break;
                    } else {
                        System.out.println("Loại vé không hợp lệ.");
                    }
                }
            }

            // Cập nhật lại các thông tin vào đối tượng vsua
            vsua.setloaive(loaive);
            vsua.setGiaVeVip(giaVeMoi * 1.5);
            vsua.setGiaVeHangNhat(giaVeMoi * 3);

            dataQuanLyVe dao = new dataQuanLyVe();
            dao.update(vsua);
            System.out.println("Đã cập nhật chuyến bay có mã: " + maVe);
        } else {
            System.out.println("Không tìm thấy chuyến bay với mã: " + maVe);
        }
    }

}
