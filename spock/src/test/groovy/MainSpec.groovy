import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Zhang
 * @since 2023/11/20
 */
class MainSpec extends Specification {

    def m = new Main()

    @Unroll
    def "fibonacci f(#a) = #b"() {
        expect:
        m.fibonacci(a) == b

        where:
        a | b
        0 | 1
        1 | 1
        2 | 2
    }

    @Unroll
    def "fibonacci IllegalArgumentException"() {
        when:
        m.fibonacci(-1)

        then:
        thrown(IllegalArgumentException)
    }
}
