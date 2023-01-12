package modernjavainaction.chap03;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionTest2 {
  public static void main(String[] args) {

    BiFunction<Integer, Integer, Double> func1 = (a1, a2) -> Math.pow(a1, a2);
    Function<Double, String> func2 = (a1) -> "Result: " + (a1 + 4);

    String result = func1.andThen(func2).apply(2, 3);

    System.out.println(result);
  }
}
