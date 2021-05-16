/*
1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.

 */
package Lesson11;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task1 {

    public static final String[] WORDS = {"a", "c", "g", "g", "a", "c", "b", "b", "a", "c", "c", "c", "c", "a", "b", "g", "g", "g", "g"};


    public static void main(String[] args) {
        Map<String, Integer> wordCount = new TreeMap();

        for (String word : WORDS) {
            wordCount.merge(word, 1, Integer::sum);
        }
        wordCount.forEach((word, frequency) -> System.out.printf("%s:%d%n", word, frequency));
    }


}
