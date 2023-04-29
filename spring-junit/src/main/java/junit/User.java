package junit;

import org.springframework.stereotype.Component;

/**
 * 前提是被测试的类需要交给Spring管理
 *
 * @author Zhang
 * @since 2023/4/29
 */
@Component
public class User {

    public void run() {
        System.out.println("ok run ...");
    }
}
