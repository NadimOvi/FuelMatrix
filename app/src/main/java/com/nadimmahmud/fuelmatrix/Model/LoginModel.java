package com.nadimmahmud.fuelmatrix.Model;

public class LoginModel {

    private int user_id;

    public LoginModel(int user_id) {
        this.user_id = user_id;
    }

    public LoginModel() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
