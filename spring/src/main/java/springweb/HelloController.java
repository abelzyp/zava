package springweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Abel
 * @date 2018/11/1
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Object hello(@RequestParam("name") String name) {
        return helloService.sayHello(name);
    }
}