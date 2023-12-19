package com.legdayDev.FootballManager.web.api;

import com.legdayDev.FootballManager.dto.CMRespDto;
import com.legdayDev.FootballManager.dto.user.UserReqDto;
import com.legdayDev.FootballManager.dto.user.UserRespDto;
import com.legdayDev.FootballManager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.legdayDev.FootballManager.dto.user.UserReqDto.*;
import static com.legdayDev.FootballManager.dto.user.UserRespDto.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/join")
    public ResponseEntity<?> join(@RequestBody @Valid JoinReqDto joinReqDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(new CMRespDto<>(-1,"유효성 검사 실패", errorMap), HttpStatus.BAD_REQUEST);
        }
        JoinRespDto joinRespDto = userService.join(joinReqDto);

        return new ResponseEntity<>(new CMRespDto<>(1,"회원가입 완료",joinRespDto),HttpStatus.CREATED);
    }
}
