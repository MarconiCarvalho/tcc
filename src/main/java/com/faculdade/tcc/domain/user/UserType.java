package com.faculdade.tcc.domain.user;

public enum UserType {

    ADMIN("admin"),
    TEACHER("teacher"),
    STUDENT("student"),
    TECHNICIANS("technicians");

    private String role;

    UserType(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
