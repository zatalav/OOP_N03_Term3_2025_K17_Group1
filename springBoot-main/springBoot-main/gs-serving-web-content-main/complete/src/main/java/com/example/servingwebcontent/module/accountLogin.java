package com.example.servingwebcontent.module;

public class accountLogin {
    private String email;
    private String password;
    private String maKhachHang;

    public accountLogin() {
    }

    public accountLogin(String email, String password, String maKhachHang) {
        this.email = email;
        this.password = password;
        this.maKhachHang = maKhachHang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
}
