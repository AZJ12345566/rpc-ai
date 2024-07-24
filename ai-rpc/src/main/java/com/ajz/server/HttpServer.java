package com.ajz.server;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/16 14:26
 * web服务器的编写(简)
 */
public interface HttpServer {
    /**
     * 启动服务器
     * @param port
     */
    void doStart(int port);
}
