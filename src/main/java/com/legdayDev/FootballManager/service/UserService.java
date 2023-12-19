package com.legdayDev.FootballManager.service;

import com.legdayDev.FootballManager.domain.user.User;
import com.legdayDev.FootballManager.domain.user.UserRepository;
import com.legdayDev.FootballManager.dto.user.UserReqDto;
import com.legdayDev.FootballManager.dto.user.UserRespDto;
import com.legdayDev.FootballManager.handler.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.legdayDev.FootballManager.dto.user.UserReqDto.*;
import static com.legdayDev.FootballManager.dto.user.UserRespDto.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public JoinRespDto join(JoinReqDto joinReqDto){
        // 유저네임 중복확인
        Optional<User> userOP = userRepository.findByUsername(joinReqDto.getUsername());
        if(userOP.isPresent()){
            throw new CustomApiException("유저네임이 중복됩니다!!");
        }

        // 회원가입
        User userPS = userRepository.save(joinReqDto.toEntity(bCryptPasswordEncoder));

        // DTO 응답
        return new JoinRespDto(userPS);
    }
}
