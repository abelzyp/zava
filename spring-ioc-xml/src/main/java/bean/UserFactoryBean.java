package bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Zhang
 * @since 2023/4/23
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
