package com.example.CommerceAppNgocIT.config;

import com.example.CommerceAppNgocIT.services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrf -> csrf.disable()).authorizeHttpRequests((auth)->auth
                    .requestMatchers("/*").permitAll()
                    .requestMatchers("/admin/**").permitAll().
//                    requestMatchers("/admin/**").hasAuthority("ADMIN").
                    anyRequest().authenticated()).formLogin(login-> login.loginPage("/login").loginProcessingUrl("/login").
                    usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/admin",true)).
                    logout( logout -> logout.logoutUrl("admin-logout").logoutSuccessUrl("/login")).
                    logout(logout -> logout.logoutUrl("/admin-logout").logoutSuccessUrl("/login"));


return http.build();
    }
    //// ma hoa password
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
@Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return webSecurity -> webSecurity.ignoring().requestMatchers("/static/**","/fontend/**","/assets/**");
}

}
