package com.example.servingwebcontent.module;

public class KhachHang {
    private String maKhachHang;
    private String user;
    private String password;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String canCuocCongDan;
    private String diaChi;
    private String city;
    private String country;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String user, String password, String hoTen, String email, String soDienThoai,
            String canCuocCongDan, String diaChi, String city, String country) {
        this.maKhachHang = maKhachHang;
        this.user = user;
        this.password = password;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.canCuocCongDan = canCuocCongDan;
        this.diaChi = diaChi;
        this.city = city;
        this.country = country;
    }

    // Getters & Setters
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
