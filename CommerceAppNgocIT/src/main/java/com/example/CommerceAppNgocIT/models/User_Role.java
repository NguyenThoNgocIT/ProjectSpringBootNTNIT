package com.example.CommerceAppNgocIT.models;

import jakarta.persistence.*;

@Entity
@Table(name="User_role")
public class User_Role {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="userId",referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name="roleId",referencedColumnName = "id")
    private Role role;

    public User_Role() {
        super();
    }

    public User_Role(Role role, User user, Long id) {
        this.role = role;
        this.user = user;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
