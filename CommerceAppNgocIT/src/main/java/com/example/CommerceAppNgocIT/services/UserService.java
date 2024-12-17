package com.example.CommerceAppNgocIT.services;

import com.example.CommerceAppNgocIT.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService  {/// controller se goi den service chu k goi len repo
    User findUserByUsername(String username); /// no tao ra phuong thuc sau do vaof userServiceImpl de thuc thi
}
