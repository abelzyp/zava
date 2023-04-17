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
public class FilterDemoTest {

    @Test
    public void getCarInsuranceName() {
        int age = 26;

        Insurance insurance = new Insurance("强大保险公司");
        Car car = new Car(insurance);
        Person person = new Person(car, age);
        FilterDemo filterDemo = new FilterDemo();
        String insuranceName = filterDemo.getCarInsuranceName(person, age);
        Assert.assertEquals(insurance.getName(), insuranceName);
    }

    @Test
    public void getCarInsuranceNameNull() {
        int age = 26;

        Car car = new Car(null);
        Person person = new Person(car, age);
        FilterDemo filterDemo = new FilterDemo();
        String insuranceName = filterDemo.getCarInsuranceName(person, age);
        Assert.assertEquals("Unknown", insuranceName);
    }

    @Test
    public void getCarInsuranceNameYoungerAge() {
        int expectedAge = 26;
        int actualAge = 24;

        Insurance insurance = new Insurance("强大保险公司");
        Car car = new Car(insurance);
        Person person = new Person(car, actualAge);
        FilterDemo filterDemo = new FilterDemo();
        String insuranceName = filterDemo.getCarInsuranceName(person, expectedAge);
        Assert.assertEquals("Unknown", insuranceName);
    }
}