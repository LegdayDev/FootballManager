package com.legdayDev.FootballManager.util;

import com.legdayDev.FootballManager.domain.user.User;
import com.legdayDev.FootballManager.domain.user.UserEnum;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

public class DummyObject {

    protected User mockUser(int id, String username, String fullName) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encPassword = passwordEncoder.encode("1234"); // 테스트 시 password 는 1234 로 고정
        return User.builder().
                id(id)
                .username(username)
                .fullName(fullName)
                .password(encPassword)
                .email(username+"@nate.com")
                .role(UserEnum.VISITOR)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    protected User dummyUser(String username, String fullName){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encPassword = passwordEncoder.encode("1234");
        return User.builder()
                .username(username)
                .password(encPassword)
                .email(username + "@nate.com")
                .fullName(fullName)
                .role(UserEnum.VISITOR)
                .build();
    }
}
