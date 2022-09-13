package com.nchu.ptas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ginger
 * @date 2022-09-13
 */
@Getter
@Setter
public class Image {
    private int picId;
    private String url;
    private boolean used;
    @JsonIgnore
    private int category;
}
