package optional.util;

import java.util.Optional;

/**
 * @author zhangyupeng
 * @date 2018/8/25
 */
public class Person {
    private Car car;
    private int age;

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }

    public int getAge() {
        return age;
    }

    public Person(Car car) {
        this.car = car;
    }

    public Person(Car car, int age) {
        this.car = car;
        this.age = age;
    }
}