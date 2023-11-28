package com.legdayDev.FootballManager.domain.player;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN("운영자"), USER("일반인");

    private String value;
}
