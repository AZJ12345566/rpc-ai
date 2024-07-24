package com.ajz.proxy;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.ajz.model.RpcRequest;
import com.ajz.model.RpcResponse;
import com.ajz.serializer.JdkSerializer;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/17 15:11
 */

/**
 * JDK动态代理
 */
public class ServiceProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //指定序列化器

        JdkSerializer serializer = new JdkSerializer();

        //构造请求
        RpcRequest rpcRequest = RpcRequest.builder().serviceName(method.getDeclaringClass().getName())
                .methodName(method.getName()).parameterTypes(method.getParameterTypes())
                .args(args).build();
        try {
            //序列化
            byte[] bodyBytes = serializer.serialize(rpcRequest);

            //发送请求
            //TODO 这里地址是硬编码(需要使用注册中心和服务发现机制解决)
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes).execute()) {
                byte[] result = httpResponse.bodyBytes();
                //反序列化
                RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
                return rpcResponse.getData();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
