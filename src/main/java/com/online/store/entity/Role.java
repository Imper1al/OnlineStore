package com.online.store.entity;

public class Role {

    private Integer id;
    private String userRole;

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                ", role='" + userRole + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
