package com.example.CommerceAppNgocIT.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="role")
public class Role {
    @Id
    @Column (name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "role")
    private Set<User_Role>roleUsers ;
    public Role() {

    }

    public Role(long id, String name, Set<User_Role> roleUsers) {
        this.id = id;
        this.name = name;
        this.roleUsers = roleUsers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User_Role> getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(Set<User_Role> roleUsers) {
        this.roleUsers = roleUsers;
    }
}
