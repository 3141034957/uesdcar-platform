package com.usedcar.vehicle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Vehicle {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String brand;       // 品牌
    private String model;       // 车型
    private Integer year;       // 年份
    private String color;       // 颜色
    private Double price;       // 价格
}
