package stream.util;

/**
 * @author zhangyupeng
 * @date 2018/8/28
 */
public class Trader {
    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader:" + name + " in " + city;
    }
}