package com.example.myapplication.data;

public class RegisterData {
    private String Login;
    private String Password;

    public RegisterData(String login, String password) {
        this.Login = login;
        this.Password = password;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
