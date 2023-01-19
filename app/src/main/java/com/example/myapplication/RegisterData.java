package com.example.myapplication;

public class RegisterData {
    private String Login;
    private String Password;

    RegisterData(String login, String password) {
        this.Login = login;
        this.Password = password;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String username) {
        Login = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
