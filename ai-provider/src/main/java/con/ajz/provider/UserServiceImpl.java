package con.ajz.provider;

import com.ajz.common.model.User;
import com.ajz.common.service.UserService;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/14 15:31
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名:" + user.getName());
        return user;
    }
}
