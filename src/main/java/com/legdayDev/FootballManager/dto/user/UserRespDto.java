package com.legdayDev.FootballManager.dto.user;

import com.legdayDev.FootballManager.domain.user.User;
import lombok.Data;

public class UserRespDto {

    @Data
    public static class JoinRespDto{
        private int id;
        private String username;
        private String fullName;

        public JoinRespDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.fullName = user.getFullName();
        }
    }
}
