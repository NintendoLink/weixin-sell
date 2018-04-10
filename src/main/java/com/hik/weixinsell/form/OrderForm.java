package com.hik.weixinsell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
/**
 * 表单验证
 */
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotEmpty(message = "名字必填")
    private String name;
    /**
     * 买家联系方式
     */
    @NotEmpty(message = "手机号码必填")
    private String phone;

    /**
     * 收货地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 买家的购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;

    public OrderForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
