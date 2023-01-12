package modernjavainaction.chap04;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static modernjavainaction.chap04.Dish.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortExample {

  public static void main(String[] args) {
    List<String> lowCaloricDishesName =
      menu.stream()
        .filter(d -> d.getCalories() < 400)     //400 칼로리 이하의 요리 추출
        .sorted(comparing(Dish::getCalories))   //칼로리 순으로 요리 정렬
        .map(Dish::getName)                     //요리명 추출
        .collect(toList());                     //모든 요리명을 리스트에 저장

    List<String> lowCaloricDishesNameParallelSort =
      menu.parallelStream()
        .filter(d -> d.getCalories() < 400)     //400 칼로리 이하의 요리 추출
        .sorted(comparing(Dish::getCalories))   //칼로리 순으로 요리 정렬
        .map(Dish::getName)                     //요리명 추출
        .collect(toList());                     //모든 요리명을 리스트에 저장

    //파이프라인 연산 만들기
    List<String> threeHighCaloricDishNames =
      menu.stream()                               //메뉴에서 스트림을 얻는다
        .filter(dish -> dish.getCalories() > 300) //고칼로리 요리 필터링
        .map(Dish::getName)                       //요리명 추출
        .limit(3)                         //선착순 세 개만 선택
        .collect(toList());                       //리스트로 반환
  }

}
