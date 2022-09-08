package com.nchu.ptas.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Ginger
 * @date 2022-09-08
 */
@Getter
@Setter
public class User {
    private int id;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
