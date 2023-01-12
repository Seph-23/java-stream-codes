package modernjavainaction.chap06;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class Examples {

  public static void main(String[] args) {
    Comparator<Dish> dishCaloriesComparator = Comparator.comparing(Dish::getCalories);

    Optional<Dish> mostCaloricDish = Dish.menu.stream()
      .collect(Collectors.maxBy(dishCaloriesComparator));
  }

}
