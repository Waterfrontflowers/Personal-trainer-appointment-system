package com.nchu.ptas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @JsonIgnore
    private int id;
    private String openId;
    private String userName;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private Date createTime;
    private Date updateTime;
    private int imageId;
}
