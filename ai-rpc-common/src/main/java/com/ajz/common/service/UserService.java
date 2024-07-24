package com.ajz.common.service;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/14 15:04
 */

import com.ajz.common.model.User;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User user);
}
