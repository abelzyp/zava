package optional;

import optional.util.Car;
import optional.util.Insurance;
import optional.util.Person;

import java.util.Optional;

/**
 * @author zhangyupeng
 * @date 2018/8/25
 */
class FilterDemo {

    /**
     * 需要get的点在于，将Optional对象看成最多包含一个元素的Stream对象
     * 如果Optional对象为空，不做任何操作
     */
    String getCarInsuranceName(Person person, int minAge) {
        return Optional.ofNullable(person)
                       .filter(p -> p.getAge() >= minAge)
                       .flatMap(Person::getCar)
                       .flatMap(Car::getInsurance)
                       .map(Insurance::getName)
                       .orElse("Unknown");
    }
}