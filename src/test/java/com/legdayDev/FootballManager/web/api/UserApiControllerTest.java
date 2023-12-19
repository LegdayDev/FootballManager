package com.legdayDev.FootballManager.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.legdayDev.FootballManager.domain.user.UserRepository;
import com.legdayDev.FootballManager.dto.user.UserReqDto;
import com.legdayDev.FootballManager.util.DummyObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static com.legdayDev.FootballManager.dto.user.UserReqDto.*;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class UserApiControllerTest extends DummyObject {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper om;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void dataInit(){
        userRepository.save(dummyUser("messi","lionel"));
    }

    @Sql("classpath:/db/datainit.sql")
    @Test
    @DisplayName("회원가입 성공 테스트")
    public void join_test() throws Exception {
        //given
        JoinReqDto reqDto = new JoinReqDto();
        reqDto.setUsername("cristiano");
        reqDto.setPassword("1234");
        reqDto.setFullName("ronaldo");
        reqDto.setEmail("cristiano@nate.com");

        String requestBody = om.writeValueAsString(reqDto);
        System.out.println("requestBody = " + requestBody);

        //when
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.
                post("/api/join").content(requestBody).contentType(MediaType.APPLICATION_JSON));
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("responseBody = " + responseBody);

        //then
        resultActions.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Sql("classpath:/db/datainit.sql")
    @Test
    @DisplayName("회원가입 실패 테스트")
    public void join_fail_test() throws Exception {
        //given
        JoinReqDto reqDto = new JoinReqDto();
        reqDto.setUsername("messi");
        reqDto.setPassword("1234");
        reqDto.setFullName("lionel");
        reqDto.setEmail("messi@nate.com");

        String requestBody = om.writeValueAsString(reqDto);
        System.out.println("requestBody = " + requestBody);

        //when
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.
                post("/api/join").content(requestBody).contentType(MediaType.APPLICATION_JSON));
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("responseBody = " + responseBody);

        //then
        resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}