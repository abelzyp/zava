package springweb;

import org.springframework.stereotype.Service;

/**
 * @author Abel
 * @date 2018/11/1
 */
@Service
public class HelloService {

    public String sayHello(String name) {
        return "Hello " + name + " !";
    }
}