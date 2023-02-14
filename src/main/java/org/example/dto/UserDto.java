package org.example.dto;

import org.example.entitys.User;
import org.example.entitys.enums.TypeUser;

public class UserDto {

    private String name;
    private String userName;
    private String userEmail;
    private String password;
    private TypeUser typeUser;
    private Long phone;

    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public Long getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public User getUserFromDto(){
        User user = new User(null, userName,userEmail,password,phone,name,typeUser);
        return user;
    }
}
