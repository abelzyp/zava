package java8Builder;

/**
 * 正常的JavaBean，没有针对Bean内部做任何修改
 *
 * @author zhangyupeng
 * @date 2020/3/11
 */
public class Bean {
    private int field1;
    private String field2;

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "field1=" + field1 +
                ", field2='" + field2 + '\'' +
                '}';
    }
}