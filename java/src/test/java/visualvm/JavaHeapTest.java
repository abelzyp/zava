package visualvm;

/**
 * @author zhangyupeng
 * @date 2019-05-28
 */
public class JavaHeapTest {
    private final static int OUTOFMEMORY = 2000000000;

    private String oom;

    private int length;

    private StringBuffer tempOOM = new StringBuffer();

    private JavaHeapTest(int leng) {
        this.length = leng;

        int i = 0;
        while (i < leng) {
            i++;
            try {
                tempOOM.append("a");
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                break;
            }
        }
        this.oom = tempOOM.toString();
    }

    private String getOom() {
        return oom;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        JavaHeapTest javaHeapTest = new JavaHeapTest(OUTOFMEMORY);
        System.out.println(javaHeapTest.getOom().length());
    }
}