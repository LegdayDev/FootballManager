package com.legdayDev.FootballManager.domain.player;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Position {
    CF("공격수"),
    MF("미드필더"),
    DF("수비수"),
    GK("골키퍼"),
    HEAD_COACH("감독"),
    COACH("코칭스태프");

    private String value;
}
