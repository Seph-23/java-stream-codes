package modernjavainaction.chap03;

import java.util.function.BiFunction;

public class BiFunctionTest {
  public static void main(String[] args) {

    BiFunction<String, String, String> func1 = (s1, s2) -> {
      return s1 + s2;
    };
    String result = func1.apply("Hello", "World");
    System.out.println(result);

    BiFunction<Integer, Integer, Double> func2 = (a1, a2) -> Double.valueOf(a1 + a2);
    Double sum = func2.apply(10, 100);
    System.out.println(sum);
  }

}
