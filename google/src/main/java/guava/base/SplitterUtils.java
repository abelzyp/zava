package guava.base;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * on():指定分隔符来分割字符串
 * limit():当分割的子字符串达到了limit个时则停止分割
 * fixedLength():根据长度来拆分字符串
 * trimResults():去掉子串中的空格
 * omitEmptyStrings():去掉空的子串
 * withKeyValueSeparator():要分割的字符串中key和value间的分隔符,分割后的子串中key和value间的分隔符默认是=
 *
 * @author Abel
 * @date 2018-12-24
 */
public class SplitterUtils {

    /**
     * @param charSequence 需要被分隔符分隔的字符串
     * @param separator    分隔符
     * @return 被分隔符分隔后的字符集合
     */
    public static List<String> splitStringWithSeparator(String charSequence, String separator) {
        return Splitter.on(separator).splitToList(charSequence);
    }
}