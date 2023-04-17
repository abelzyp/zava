package optional.util;

import java.util.Optional;

/**
 * @author zhangyupeng
 * @date 2018/8/25
 */
public class Car {
    private Insurance insurance;

    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }

    public Car(Insurance insurance) {
        this.insurance = insurance;
    }
}