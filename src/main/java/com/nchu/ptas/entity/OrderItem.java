package com.nchu.ptas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Ginger
 * @date 2022-09-14
 */
@Getter
@Setter
public class OrderItem {
    @JsonIgnore
    private int id;
    private int orderId;
    private int courseId;
    private int coachId;
    private String courseName;
    private String coachName;
    private String courseImage;
    private double currentUnitPrice;
    private int quantity;
    private double totalPrice;
    private Date createTime;
    private Date updateTime;
    @JsonIgnore
    private int success;

}
