package com.nchu.ptas.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Ginger
 * @date 2022-09-14
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    private int id;
    private long orderNo;
    private int userId;
    private double payment;
    private int paymentType;
    private int status;
    private Date paymentTime;
    private Date endTime;
    private Date closeTime;
    private Date createTime;
    private Date updateTime;
}
