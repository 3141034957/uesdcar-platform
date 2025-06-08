package com.usedcar.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;        // 购买用户ID

    private Long vehicleId;     // 车辆ID

    private Double price;       // 成交价格

    private String status;      // 订单状态: PENDING, PAID, COMPLETED, CANCELED

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
