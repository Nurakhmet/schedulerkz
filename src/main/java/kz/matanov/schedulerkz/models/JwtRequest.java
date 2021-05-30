package kz.matanov.schedulerkz.models;


import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 123456789L;
    private String email;
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
}
