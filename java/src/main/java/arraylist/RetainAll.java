package arraylist;

import java.util.ArrayList;

/**
 * retainAll() 方法用于保留arraylist 中在指定集合中也存在的那些元素，也就是删除指定集合中不存在的那些元素。
 *
 * @author Zhang
 * @since 2023/4/25
 */
public class RetainAll {
    public static void main(String[] args) {

        // 创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();

        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");

        System.out.println("ArrayList 1: " + sites);

        // 创建另一个动态数组
        ArrayList<String> sites2 = new ArrayList<>();

        // 往动态数组中添加元素
        sites2.add("Wiki");
        sites2.add("Runoob");
        sites2.add("Google");
        System.out.println("ArrayList 2: " + sites2);

        // 保留元素
        sites.retainAll(sites2);
        System.out.println("保留的元素: " + sites);
    }
}
