package java8Builder;

import org.junit.Test;

/**
 * @author zhangyupeng
 * @date 2020/3/11
 */
public class BuilderTest {

    @Test
    public void test() {
        Bean bean = Builder.of(Bean::new)
                .with(Bean::setField1, 22)
                .with(Bean::setField2, "LLP")
                .build();
        System.out.println(bean);
    }
}