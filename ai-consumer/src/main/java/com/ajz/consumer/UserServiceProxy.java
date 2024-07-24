package com.ajz.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.ajz.common.model.User;
import com.ajz.common.service.UserService;
import com.ajz.model.RpcRequest;
import com.ajz.model.RpcResponse;
import com.ajz.serializer.JdkSerializer;

import java.io.IOException;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/17 14:49
 */

/**
 * 这里实现UserService接口是需要构造HTTP请求去调用服务提供者
 */

public class UserServiceProxy implements UserService {
    @Override
    public User getUser(User user) {
        //指定序列化器
        JdkSerializer serializer = new JdkSerializer();

        //发请求
        RpcRequest rpcRequest = RpcRequest.builder().serviceName(UserService.class.getName())
                .methodName("getUser").parameterTypes(new Class[]{User.class})
                .args(new Object[]{user}).build();

        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes).execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
