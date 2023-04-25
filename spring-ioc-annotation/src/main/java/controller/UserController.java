package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import service.UserService;

/**
 * 从Java 5开始，Java增加了对于注解的支持。Spring 2.5开始提供注解支持。
 *
 * @author Zhang
 * @since 2023/4/24
 */
@Controller
public class UserController {

    /**
     * 注入service
     * 根据类型找到对应实现类对象,完成注入
     * 1 属性注入
     * 2 set方法注入
     * 3 构造方法注入
     * 4 形参上注入
     */
    @Autowired
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

    public void add() {
        System.out.println("controller执行");
        userService.add();
    }
}
