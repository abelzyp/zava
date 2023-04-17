package stream;

import stream.util.TraModel;
import stream.util.Trader;
import stream.util.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhangyupeng
 * @date 2018/8/28
 */
public class TraDemo {
    public static void main(String[] args) {
        //1 找出2011年交易，按照交易额排序
        List<Transaction> tr2011 = TraModel.transactions.stream()
                                                        .filter(transaction -> transaction.getYear() == 2011)
                                                        .sorted(Comparator.comparingInt(Transaction::getValue))
                                                        .collect(Collectors.toList());
        System.out.println(tr2011);

        //2 交易员都在哪些不同城市工作过？
        List<String> cities = TraModel.transactions.stream()
                                                   .map(transaction -> transaction.getTrader().getCity())
                                                   .distinct()
                                                   .collect(Collectors.toList());
        System.out.println(cities);

        //3 查找所有来自于剑桥的交易员，按姓名排序
        List<Trader> traders = TraModel.transactions.stream()
                                                    .map(Transaction::getTrader)
                                                    .filter(trader -> "Cambridge".equals(trader.getCity()))
                                                    .sorted(Comparator.comparing(Trader::getName))
                                                    .collect(Collectors.toList());
        System.out.println(traders);

        //4 返回所有交易员的姓名，按字母顺序排序
        List<String> traderStr = TraModel.transactions.stream()
                                                      .map(transaction -> transaction.getTrader().getName())
                                                      .distinct()
                                                      .sorted(Comparator.comparing(String::hashCode))
                                                      .collect(Collectors.toList());
        System.out.println(traderStr);

        //5 有没有交易员是在米兰工作的？
        Optional<Trader> milanBased = TraModel.transactions.stream()
                                                           .map(Transaction::getTrader)
                                                           .filter(trader -> "Milan".equals(trader.getCity()))
                                                           .findAny();
        System.out.println(milanBased.isPresent());

        boolean milan = TraModel.transactions.stream().anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        System.out.println(milan);

        System.out.println("==========");
        //6 打印生活在剑桥的交易员的所有交易额
        TraModel.transactions.stream()
                             .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                             .forEach(transaction -> System.out.println(transaction.getValue()));
        System.out.println("==========");

        //7 所有交易中的最高交易额
        Optional<Integer> highestValue = TraModel.transactions.stream()
                                                              .map(Transaction::getValue)
                                                              .max(Integer::compareTo);
        System.out.println(highestValue.orElse(0));
        Optional<Integer> maxValue = TraModel.transactions.stream()
                                                          .map(Transaction::getValue)
                                                          .reduce(Integer::max);
        System.out.println(maxValue.orElse(0));
        System.out.println("==========");

        //8 找到交易额最小的交易
        Optional<Transaction> smallestTransaction = TraModel.transactions.stream()
                                                                         .min(Comparator.comparingInt(Transaction::getValue));
        System.out.println(smallestTransaction);

        Optional<Transaction> smallestTransaction1 = TraModel.transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(smallestTransaction1);
    }
}