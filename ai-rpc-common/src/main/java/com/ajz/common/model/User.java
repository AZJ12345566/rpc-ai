package com.ajz.common.model;

import java.io.Serializable;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/14 15:03
 */

/**
 * 用户
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
