package com.hik.weixinsell.exception;

import com.hik.weixinsell.enums.ResultEnum;

public class SellException extends RuntimeException {
    private Integer code;


    public SellException(ResultEnum resultEnum) {
        //传入父类的构造方法
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
