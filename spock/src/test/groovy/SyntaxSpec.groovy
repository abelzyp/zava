import spock.lang.Specification
import spock.lang.Unroll


/**
 * setup / given: 单测case中预设变量
 * when + then: when中执行被测试代码, then中对结果断言
 * expect + where: expect可替代when + then单独存在, where需搭配expect使用
 *
 * @author Zhang
 * @since 2023/11/20
 */
class SyntaxSpec extends Specification {

    def "sum test"() {
        given:
        def a = 1
        def b = 2

        when:
        def c = a + b

        then:
        c == 3
    }

    def "sum test2"() {
        given:
        def a = 1
        def b = 2

        expect:
        a + b == 3
    }

    def "sum test3"(int a, int b, int c) {
        expect:
        a + b == c

        where:
        a  | b   | c
        1  | 2   | 3
        -1 | 1   | 0
        1  | 100 | 101
    }

    @Unroll
    def "sum test for #a+#b=#c"() {
        expect:
        a + b == c

        where:
        a  | b   | c
        1  | 2   | 3
        -1 | 1   | 0
        1  | 100 | 101
    }
}