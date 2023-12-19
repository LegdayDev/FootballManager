package com.legdayDev.FootballManager.service;

import com.legdayDev.FootballManager.domain.user.User;
import com.legdayDev.FootballManager.domain.user.UserRepository;
import com.legdayDev.FootballManager.dto.user.UserReqDto;
import com.legdayDev.FootballManager.dto.user.UserRespDto;
import com.legdayDev.FootballManager.util.DummyObject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static com.legdayDev.FootballManager.dto.user.UserReqDto.*;
import static com.legdayDev.FootballManager.dto.user.UserRespDto.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest extends DummyObject {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("API 회원가입 테스트")
    public void join_test() throws Exception {
        //given
        JoinReqDto reqDto = new JoinReqDto();
        reqDto.setUsername("cristiano");
        reqDto.setPassword("1234");
        reqDto.setFullName("ronaldo");
        reqDto.setEmail("cr7@nate.com");

        // stub 1
        Mockito.when(userRepository.findByUsername(reqDto.getUsername())).thenReturn(Optional.empty());

        // stub 2
        User user = mockUser(1, "cristiano", "ronaldo");
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);

        //when
        JoinRespDto respDto = userService.join(reqDto);
        System.out.println("joinRespDto = " + respDto);

        //then
        assertThat(respDto.getId()).isEqualTo(1);
        assertThat(respDto.getUsername()).isEqualTo("cristiano");
        assertThat(respDto.getFullName()).isEqualTo("ronaldo");
    }
}