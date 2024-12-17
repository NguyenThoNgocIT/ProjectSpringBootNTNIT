package com.example.CommerceAppNgocIT.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
@Entity
@Table(name="User")
public class User {
    @Id
    @Column(name="id")

@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled") ///check xem tk do con hd k
    private Boolean enabled;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "gender")
    private Boolean gender;


    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<User_Role> userRoles;/// join giưa các cai bang vơi nhau mqh 1 nhiu

public User() {
    super();
}
    // Getters and setters (hoặc bạn có thể sử dụng Lombok để giảm bớt mã)

    public User(Long id, String userName, String password, Boolean enabled, String fullName, Boolean gender
                , String address, String email, String telephone, Set<User_Role> userRoles)
    {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.userRoles = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<User_Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User_Role> userRoles) {
        this.userRoles = userRoles;
    }
}

