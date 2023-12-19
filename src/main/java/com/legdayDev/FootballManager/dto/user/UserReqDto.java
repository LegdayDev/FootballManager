package com.legdayDev.FootballManager.dto.user;

import com.legdayDev.FootballManager.domain.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserReqDto {

    @Data
    public static class JoinReqDto{
        @Pattern(regexp = "^[a-zA-Z0-9]{2,20}$", message = "영문 or 숫자 2~20자 이내로 작성해주세요")
        @NotBlank // NULL or 공백
        private String username;

        @NotBlank
        @Pattern(regexp = "^^[a-zA-Z가-힣]{1,20}$", message = "영문 or 한글 1~20자 이내로 작성해주세요")
        private String fullName;

        @NotBlank
        @Size(min = 4,max = 20)
        private String password;

        @Pattern(regexp = "^[a-zA-Z0-9]{2,10}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}$", message = "이메일 형식으로 작성해주세요")
        @NotBlank
        private String email;

        public User toEntity(BCryptPasswordEncoder passwordEncoder){
            return User.builder()
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .email(email)
                    .fullName(fullName)
                    .role("VISITOR")
                    .build();
        }
    }
}
