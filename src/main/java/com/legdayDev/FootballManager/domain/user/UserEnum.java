package com.legdayDev.FootballManager.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserEnum {
    ADMIN("관리자"), VISITOR("사용자");

    private String value;
}
