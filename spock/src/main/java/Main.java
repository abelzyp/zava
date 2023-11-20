/**
 * @author Zhang
 * @since 2023/11/20
 */
public class Main {
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N must be greater than 0.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long n1 = 1, n2 = 1, tmp;
        for (int i = 2; i <= n; i++) {
            tmp = n1;
            n1 = n2;
            n2 = tmp + n2;
        }
        return n2;
    }
}