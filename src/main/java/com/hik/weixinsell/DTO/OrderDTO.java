package com.hik.weixinsell.DTO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hik.weixinsell.dataobject.OrderDetail;
import com.hik.weixinsell.utils.serializer.Date2LongSerializer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDTO {


    private String orderId;
    /**
     * 买家名字
     */
    private String buyerName;
    /**
     * 买家联系
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家微信ID
     */
    private String buyerOpenid;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态，默认为下单
     */
    private Integer orderStatus;
    /**
     * 支付状态,默认为未支付
     */
    private Integer payStatus;
    /**
     * 创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;


    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
