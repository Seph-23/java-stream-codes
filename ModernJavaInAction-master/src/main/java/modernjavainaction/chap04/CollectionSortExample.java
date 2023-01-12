package modernjavainaction.chap04;

import static modernjavainaction.chap04.Dish.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortExample {

  public static void main(String[] args) {
    //JAVA 7 Code
    List<Dish> lowCaloricDishes = new ArrayList<>();
    for (Dish dish : menu) {
      if (dish.getCalories() < 400) {
        lowCaloricDishes.add(dish);
      }
    }
    Collections.sort(lowCaloricDishes, new Comparator<Dish>() {   //익명 클래스로 요리 정렬
      @Override
      public int compare(Dish o1, Dish o2) {
        return Integer.compare(o1.getCalories(), o2.getCalories());
      }
    });
    List<String> lowCaloricDishesName = new ArrayList<>();
    for (Dish dish : lowCaloricDishes) {
      lowCaloricDishesName.add(dish.getName());   //정렬된 리스트를 처리하면서 요리 이름 선택
    }
  }

}
