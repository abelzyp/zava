package optional;

import optional.util.Car;
import optional.util.Insurance;
import optional.util.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhangyupeng
 * @date 2018/8/25
 */
public class FlatMapDemoTest {

    @Test
    public void getCarInsuranceName() {
        Insurance insurance = new Insurance("强大保险公司");
        Car car = new Car(insurance);
        Person person = new Person(car);
        FlatMapDemo flatMapDemo = new FlatMapDemo();
        String insuranceName = flatMapDemo.getCarInsuranceName(person);
        Assert.assertEquals(insurance.getName(), insuranceName);
    }

    @Test
    public void getCarInsuranceNameNull() {
        Car car = new Car(null);
        Person person = new Person(car);
        FlatMapDemo flatMapDemo = new FlatMapDemo();
        String insuranceName = flatMapDemo.getCarInsuranceName(person);
        Assert.assertEquals("Unknown", insuranceName);
    }
}