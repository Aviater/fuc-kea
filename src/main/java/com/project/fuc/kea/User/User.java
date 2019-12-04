package com.project.fuc.kea.User;

public class User {
    private int userId;
    private String name;
   // private String userName;
    private String email;
    private String password;

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId){
        this.userId=userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
