package spi;

/**
 * @author Zhang Yupeng
 * @since 2022/1/15
 */
public class SpiServiceImpl2 implements SpiService {
    @Override
    public void execute() {
        System.out.println(this.getClass().getSimpleName());
    }
}
