package modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {
  public static void main(String[] args) {
    List<Integer> integerList = map(
      Arrays.asList("lambdas", "in", "action"),
      (String s) -> s.length()      //Function의 apply 메서드를 구현하는 람다
    );
    System.out.println("integerList = " + integerList);
  }

  public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
    List<R> result = new ArrayList<>();
    for (T t : list) {
      result.add(f.apply(t));
    }
    return result;
  }
}
