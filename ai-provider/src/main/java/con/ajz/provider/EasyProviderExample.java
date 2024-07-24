package con.ajz.provider;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/14 15:33
 */

import com.ajz.common.service.UserService;
import com.ajz.registry.LocalRegistry;
import com.ajz.server.HttpServer;
import com.ajz.server.VertxHttpServer;

/**
 * 简易服务提供者
 * main方法中编写提供服务的代码
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        //启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
