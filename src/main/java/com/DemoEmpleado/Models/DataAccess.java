package com.DemoEmpleado.Models;

import lombok.Data;


public class DataAccess {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setCorreo(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
