package guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.Set;

/**
 * Table它有两个支持所有类型的键：”行”和”列”。
 * Row Column Value
 *
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class TableTest {

    @Test
    public void test() {
        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("jack", "java", 100);
        table.put("jack", "c", 90);
        table.put("mike", "java", 93);
        table.put("mike", "c", 100);

        Set<Table.Cell<String, String, Integer>> cellSet = table.cellSet();
        cellSet.forEach(c -> System.out.println(c.getRowKey() + " " + c.getColumnKey() + " " + c.getValue()));

        System.out.println(table);
        System.out.println(table.row("jack"));
        System.out.println(table.rowKeySet());
        System.out.println(table.columnKeySet());
        System.out.println(table.values());
    }
}