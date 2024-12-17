package com.example.CommerceAppNgocIT.repositorys;

import com.example.CommerceAppNgocIT.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {///user trong cai model
    User findByUserName(String UserName);//// tim theo username

}
