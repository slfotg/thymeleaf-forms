package com.github.slfotg.web.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class RegisterForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String username;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordVerify;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public void setPasswordVerify(String passwordVerify) {
        this.passwordVerify = passwordVerify;
    }

    @Override
    public String toString() {
        return "RegisterForm [username=" + username + ", email=" + email + ", password=" + password
                + ", passwordVerify=" + passwordVerify + "]";
    }
}
