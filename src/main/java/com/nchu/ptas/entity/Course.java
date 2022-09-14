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
public class Course {
    private int id;
    private int coachId;
    private String name;
    private String subtitle;
    private String mainImage;
    private String subImage;
    private String detail;
    private String price;
    private int stock;
    private int status;
    private Date courseTime;
    private Date createTime;
    private Date updateTime;
}
