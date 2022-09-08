package com.nchu.ptas.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Ginger
 * @date 2022-09-02
 */
@Setter
@Getter
public class Card {
    private Integer id;
    private Integer type;
    private String cardNumber;
    private Integer price;
    private Integer used;
    private Date expirationTime;
}
