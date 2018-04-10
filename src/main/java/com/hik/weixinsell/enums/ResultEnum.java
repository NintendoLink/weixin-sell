package com.hik.weixinsell.enums;

public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不正确"),
    ORDER_NO_EXIST(12,"订单不存在"),
    ORDER_STATUS_ERROR(13,"订单状态不正确"),
    ORDER_UPDATE_FAILED(14,"订单更新失败"),
    ORDER_DETAIL_EMPTY(15,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(16,"支付状态错误"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ResultEnum() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
