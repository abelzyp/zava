package optional;

import optional.util.Car;
import optional.util.Insurance;
import optional.util.Person;

import java.util.Optional;

/**
 * @author zhangyupeng
 * @date 2018/8/25
 */
class FlatMapDemo {

    /**
     * 层层获取Car的Insurance名称的方法
     *
     * @param person 主要看Model定义
     */
    String getCarInsuranceName(Person person) {
        return Optional.ofNullable(person)
                       .flatMap(Person::getCar)
                       .flatMap(Car::getInsurance)
                       .map(Insurance::getName)
                       .orElse("Unknown");
    }
}