package com.example.CommerceAppNgocIT.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class env {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
