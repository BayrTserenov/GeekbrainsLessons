//3. Большая задача:
//
//    Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
//    Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//    Для хранения фруктов внутри коробки можно использовать ArrayList;
//    Сделать метод getWeight(), который высчитывает вес коробки, зная количество фруктов и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
//    Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true – если она равны по весу,
//    false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//    Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами). Соответственно,
//    в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//    Не забываем про метод добавления фрукта в коробку.

package Lesson10;

import java.util.ArrayList;

public class Box implements HasWeight {
    Box(String boxID) {
        BoxID = boxID;
    }

    public String getBoxID() {
        return BoxID;
    }

    public String BoxID;

    int fruitCount = 0;
    private ArrayList<Fruit> fruits;

    public void putFruit(Fruit fruit) {
        this.fruits.add(fruit);
        fruitCount++;
    }

    public void removeFruit(Fruit fruit) {
        if (fruitCount > 0) {
            this.fruits.remove(fruit);
            fruitCount--;
        } else{
            System.out.println("В коробке пусто");
        }
    }


    @Override
    public float getWeight() {
        float weight = this.getWeight()*fruitCount;
        return weight;
    }


}
