package dao;

import org.springframework.stereotype.Repository;

/**
 * @author Zhang
 * @since 2023/4/24
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("dao执行");
    }
}
