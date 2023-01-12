package modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import scala.Int;

public class Apple {

  private Integer weight = 0;
  private Color color;

  public Apple(int weight, Color color) {
    this.weight = weight;
    this.color = color;
  }

  public static void main(String[] args) {
    List<Apple> inventory = new ArrayList<>();
    inventory.add(new Apple(10, Color.RED));
    inventory.add(new Apple(20, Color.RED));

//    inventory.sort(Comparator.comparing((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())));
//    inventory.sort(Comparator.comparing());
    Comparator<Apple> appleComparator = (Apple a1, Apple a2) -> a1.getWeight()
      .compareTo(a2.getWeight());
    inventory.sort(appleComparator);
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  @SuppressWarnings("boxing")
  @Override
  public String toString() {
    return String.format("Apple{color=%s, weight=%d}", color, weight);
  }

}