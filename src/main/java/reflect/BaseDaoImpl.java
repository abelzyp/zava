package reflect;

/**
 * @author Zhang
 * @since 2023/4/11
 */
public class BaseDaoImpl extends BaseDao<Integer> {
    public BaseDaoImpl() {
        System.out.println("impl");
    }

    public static void main(String[] args) {
        new BaseDaoImpl();
    }
}
