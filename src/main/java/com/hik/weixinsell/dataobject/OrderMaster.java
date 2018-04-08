package com.hik.weixinsell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class OrderMaster {

    /**
     * 订单ID
     */
    @Id
    private String orderID;
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
    private Integer orderStatus=0;
    /**
     * 支付状态,默认为未支付
     */
    private Integer payStatus=0;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */

    private Date updateTime;
}
