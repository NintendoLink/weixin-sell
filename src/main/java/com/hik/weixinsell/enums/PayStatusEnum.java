package com.hik.weixinsell.enums;

public enum PayStatusEnum {
    WAIT(0,"支付成功"),
    SUCCESS(1,"支付成功"),

    ;
    private Integer code;
    private String message;


    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
