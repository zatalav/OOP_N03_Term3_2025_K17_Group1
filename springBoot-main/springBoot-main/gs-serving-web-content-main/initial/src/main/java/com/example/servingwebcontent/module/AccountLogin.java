package com.example.servingwebcontent.module;

public class AccountLogin {
    private String email;
    private String user;
    private String password;

    public AccountLogin() {
    }

    public AccountLogin(String user, String email, String password) {
        this.user = user;
        this.email = email;
        this.password = password;
    }

    public String getemail() {
        return email;
    }

    public void setgmail(String email) {
        this.email = email;
    }

    public String getuser() {
        return user;
    }

    public void setuser(String user) {
        this.user = user;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
