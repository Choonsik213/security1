package com.cos.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/user/**").authenticated()    // "/user/**" 경로는 USER 권한 필요
//                        .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")  // "/admin/**" 경로는 ADMIN 권한 필요
//                        .requestMatchers("/admin/**").hasRole("ADMIN")  // "/admin/**" 경로는 ADMIN 권한 필요
//                        .anyRequest().permitAll()   // 나머지 요청들은 인증된 사용자만 접근 가능
//
//                )
//                .formLogin(login -> login
//                        .loginPage("/login")
//                        .permitAll()
//                )
//
//                .build();
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // CSRF 보안 비활성화
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").authenticated() // "/user/**" 경로는 인증된 사용자만 접근 가능
                        .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER") // "ROLE_" 자동 추가됨
                        .requestMatchers("/admin/**").hasRole("ADMIN") // "ROLE_" 자동 추가됨
                        .anyRequest().permitAll() // 나머지 요청은 모두 허용
                )
                .formLogin(login -> login
                        .loginPage("/login") // 커스텀 로그인 페이지 설정
                        .permitAll() // 로그인 페이지 접근 허용
                )
                .build(); // 🔴 `http.build()`를 호출해야 `SecurityFilterChain`을 반환할 수 있음!
    }

}