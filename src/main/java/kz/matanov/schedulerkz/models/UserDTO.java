package kz.matanov.schedulerkz.models;

import kz.matanov.schedulerkz.entities.Roles;


import java.io.Serializable;
import java.util.List;


public class UserDTO implements Serializable {

    private Long id;
    private String email;
    private String fullName;
    private String password;
    private List<Roles> roles;

    public UserDTO(Long id, String email, String fullName, List<Roles> roles) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.roles = roles;
    }

    public UserDTO(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
