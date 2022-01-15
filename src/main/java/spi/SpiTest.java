package spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Zhang Yupeng
 * @since 2022/1/15
 */
public class SpiTest {
    public static void main(String[] args) {
        Iterator<SpiService> providers = Service.providers(SpiService.class);
        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);

        while (providers.hasNext()) {
            SpiService ser = providers.next();
            ser.execute();
        }
        System.out.println("--------------------");
        Iterator<SpiService> iterator = load.iterator();
        while (iterator.hasNext()) {
            SpiService ser = iterator.next();
            ser.execute();
        }
    }
}
