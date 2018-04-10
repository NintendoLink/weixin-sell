package com.hik.weixinsell.enums;

public enum ResultEnum {
    PARAM_ERROR(1,"参数不正确"),


    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不正确"),
    ORDER_NO_EXIST(12,"订单不存在"),
    ORDER_STATUS_ERROR(13,"订单状态不正确"),
    ORDER_UPDATE_FAILED(14,"订单更新失败"),
    ORDER_DETAIL_EMPTY(15,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(16,"支付状态错误"),
    CART_EMPTY(17,"购物车不能为空"),
    ORDER_OWNER_ERROR(18,"该订单不属于当前用户")
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
