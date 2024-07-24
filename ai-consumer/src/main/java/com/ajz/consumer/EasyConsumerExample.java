package com.ajz.consumer;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/14 15:37
 */

import com.ajz.common.model.User;
import com.ajz.common.service.UserService;
import com.ajz.proxy.ServiceProxyFactory;

/**
 * 简单服务消费者
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        //TODO 需要获取UserService的实现类对象
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("xiaoai");
        User newUser = userService.getUser(user);
        if(newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
