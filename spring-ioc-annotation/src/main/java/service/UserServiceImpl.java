package service;

import dao.UserDao;
import org.springframework.stereotype.Service;

/**
 * @author Zhang
 * @since 2023/4/24
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 5 只有一个有参数构造函数时无需注解
     */
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("service执行");
        userDao.add();
    }
}
