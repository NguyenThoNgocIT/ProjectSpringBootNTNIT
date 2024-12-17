package com.example.CommerceAppNgocIT.services;

import com.example.CommerceAppNgocIT.models.CustomUserDetails;
import com.example.CommerceAppNgocIT.models.User;
import com.example.CommerceAppNgocIT.models.User_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService; // Sử dụng UserService để lấy người dùng từ DB

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tìm người dùng qua tên đăng nhập
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Lấy danh sách các quyền (roles) của người dùng
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<User_Role> roles = user.getUserRoles(); // Lấy danh sách User_Role của người dùng

        // Duyệt qua các quyền (roles) và thêm chúng vào grantedAuthorities
        for (User_Role userRole : roles) {

            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
        }

        // Trả về CustomUserDetails với thông tin người dùng và các quyền (roles)
        return new CustomUserDetails(user, grantedAuthorities);
    }
}
