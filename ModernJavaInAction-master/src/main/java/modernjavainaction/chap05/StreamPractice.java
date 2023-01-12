package modernjavainaction.chap05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
      new Transaction(brian, 2011, 300),
      new Transaction(raoul, 2012, 1000),
      new Transaction(raoul, 2011, 400),
      new Transaction(mario, 2012, 710),
      new Transaction(mario, 2012, 700),
      new Transaction(alan, 2012, 950)
    );

    System.out.println("transactions = " + transactions);

    //2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하십시오.
    List<Transaction> practice1 = transactions.stream()
      .filter(d -> d.getYear() == 2011)
      .sorted(Comparator.comparing(Transaction::getYear))
      .collect(Collectors.toList());

    System.out.println("practice1 = " + practice1);

    //거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
    List<String> practice2 = transactions.stream()
      .map(d -> d.getTrader().getCity())
      .distinct()
      .collect(Collectors.toList());

    System.out.println("practice2 = " + practice2);

    //케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
    List<Transaction> practice3 = transactions.stream()
      .filter(trans -> trans.getTrader().getCity().equals("Cambridge"))
      .sorted(Comparator.comparing(trans -> trans.getTrader().getName()))
      .collect(Collectors.toList());

    System.out.println("practice3 = " + practice3);

    List<Trader> practice3_2 = transactions.stream()
      .map(Transaction::getTrader)
      .filter(a -> a.getCity().equals("Cambridge"))
      .sorted(Comparator.comparing(Trader::getName))
      .collect(Collectors.toList());

    System.out.println("practice3_2 = " + practice3_2);

    //모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
    List<String> practice4 = transactions.stream()
      .map(trans -> trans.getTrader().getName())
      .distinct()
      .sorted()
      .collect(Collectors.toList());

    System.out.println("practice4 = " + practice4);

    //밀라노에 거래자가 있는가?
    boolean practice5 = transactions.stream()
      .anyMatch(trans -> trans.getTrader().getCity().equals("Milan"));

    System.out.println("practice5 = " + practice5);

    //케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하십시오.
    transactions.stream()
      .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
      .map(Transaction::getValue)
      .forEach(System.out::println);

    //전체 트랜잭션 중 최댓값은 얼마인가?
    Optional<Integer> practice7 = transactions.stream()
      .map(Transaction::getValue)
      .reduce(Integer::max);

    System.out.println("practice7 = " + practice7.get());


    //피모나치 수열 생성
    Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
      .limit(10)
      .map(t -> t[0])
      .forEach(System.out::println);

    Stream.generate(Math::random)
      .limit(10)
      .forEach(System.out::println);
  }

}
