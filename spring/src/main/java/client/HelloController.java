package client;

import org.springframework.beans.factory.annotation.Autowired;
import spring.server.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Abel
 * @date 2018/11/1
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Object hello(@RequestParam("name") String name) {
        return helloService.sayHello(name);
    }
}