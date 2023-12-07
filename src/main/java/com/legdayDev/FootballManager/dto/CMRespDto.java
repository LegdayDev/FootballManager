package com.legdayDev.FootballManager.dto;

import lombok.Data;

@Data
public class CMRespDto<T> {
    private int code;
    private String msg;
    private T data;

    public CMRespDto(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
