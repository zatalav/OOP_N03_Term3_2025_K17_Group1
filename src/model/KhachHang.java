package src.model;

public class KhachHang implements Identifiable {
    @Override
    public String getMa() {
        return maKhachHang;
    }

    public String maKhachHang;
    public String hoTen;
    private String email;
    private String soDienThoai;
    private String canCuocCongDan;
    private String diaChi

    public KhachHang() {
    }

    public KhachHang(String ma, String ten, String email, String sdt, String canCuocCongDan, String diaChi) {
        this.maKhachHang = ma;
        this.hoTen = ten;
        this.email = email;
        this.soDienThoai = sdt;
        this.canCuocCongDan = canCuocCongDan;
        this.diaChi = diaChi;
    }

    // Getters & Setters
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getEmail() {
        return email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        this.canCuocCongDan = canCuocCongDan;
    }

     public String getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return String.format("Mã KH: %-8s | Họ tên: %-20s | Email: %-25s | SĐT: %-11s | CCCD: %-12s | Địa chỉ: %s",
                maKhachHang, hoTen, email, soDienThoai, canCuocCongDan, diaChi);
    }
}
