package idea;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * 工欲善其事必先利其器，熟练掌握并使用集成开发环境，能够帮助开发者快速而优雅的写出高质量代码，同时，对开发工具使用的熟练程度也从某种程度上反应出开发者编码功底。
 *
 * 各种编程语言都有或多或少的模板代码，这些模板代码的编写并没有什么技术含量，在实际编码的过程当中很有可能会成为影响开发者效率的绊脚石，而大多数代码编辑器对特有的编程语言有很多快捷操作支持，作为被广泛使用的Java[Android]集成开发环境，本文对IDEA常用提高开发效率的小技巧进行总结，希望能够帮助开发者码出效率、码出水平、码出满满的幸福感。
 *
 * 当然，此文虽然主要介绍IDEA的便捷操作，但是也并不仅限于此，文末列出笔者常用的开发工具，供读者参考使用。
 *
 * IntelliJ IDEA 常用插件一览:
 * https://juejin.cn/post/6844903973057462280
 *
 * 在线工具:
 * https://tool.lu/
 *
 * 推荐一个百度开发的chrome插件：FeHelper
 *
 * @author Zhang Yupeng
 * @since 2020/11/22
 */
public class HotKeys implements Serializable {

    private static final long serialVersionUID = 2749234813978759276L;

    private HotKeys hotKeys;

    public void var() {
        // 1.变量声明
        //"meituan".var
        String meituan = "meituan";
        //new HotKeys().var
        HotKeys hotKeys = new HotKeys();

        // 2.null, not null, nn
        //new HotKeys().null
        if (new HotKeys() == null) {
        }
        //new HotKeys().notnull
        if (new HotKeys() != null) {
        }
        //new HotKeys().nn
        if (new HotKeys() != null) {
        }

        // 3.not, if, for, fori, forr
        //new ArrayList<String>().var
        ArrayList<String> list = new ArrayList<>();
        //CollectionUtils.isEmpty(list).not.if
        //list.for
        for (String s : list) {
        }
        //list.fori
        for (int i = 0; i < list.size(); i++) {
        }
        //list.forr
        for (int i = list.size() - 1; i >= 0; i--) {
        }

        // 4.inst, instanceof
        //new HotKeys().inst
        if (new HotKeys() instanceof HotKeys) {
            new HotKeys();
        }

        // 5.cast, castvar
        int i = 123;
        //i.cast
        // ((long) i)
        //i.castvar
        long l = (long) i;

        // 6.控制台输出 sout, soutv, serr
        //"meituan".sout
        System.out.println("meituan");
        //"meituan".soutv
        System.out.println("\"meituan\" = " + "meituan");
        //"meituan".serr
        System.err.println("meituan");

        // 7.多线程同步, x.sync
        //"meituan".sync
        synchronized ("meituan") {
        }

        // 8.try-catch x.try
        //"meituan".try
        try {
            String meituan1 = "meituan";
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 9.全局变量声明 x.field
        //new HotKeys().field
        this.hotKeys = new HotKeys();

        // 10.返回值 x.return
        //new HotKeys().return
    }

    // 11.常量声明
    //psf
    public static final String meituan1 = "meituan";
    //prsf
    private static final String meituan2 = "meituan";
    //psfi
    public static final int meituan3 = 1;
    //psfs
    public static final String meituan4 = "meituan";
}