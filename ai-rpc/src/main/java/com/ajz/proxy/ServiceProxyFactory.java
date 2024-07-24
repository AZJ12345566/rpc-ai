package com.ajz.proxy;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/17 15:25
 */

import java.lang.reflect.Proxy;

/**
 * 服务代理工厂(用于创建代理对象)
 */
public class ServiceProxyFactory {
    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy()
        );
    }
}
