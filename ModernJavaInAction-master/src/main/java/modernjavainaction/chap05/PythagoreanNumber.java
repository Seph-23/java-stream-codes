package modernjavainaction.chap05;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanNumber {
  public static void main(String[] args) {

    int[] pythagorean = new int[]{3,4,5};

    boolean result =
      Math.sqrt(pythagorean[0] * pythagorean[0] + pythagorean[1] * pythagorean[1]) % 1 == 0;

//    System.out.println("result = " + result);

    Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
      .flatMap(a ->
        IntStream.rangeClosed(a, 100)
          .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
          .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
      );

    pythagoreanTriples.limit(100)
      .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
  }
}
