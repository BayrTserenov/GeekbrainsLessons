/*
1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче
массива другого размера
необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст
 вместо числа),
должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат
 неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
MyArrayDataException и вывести результат расчета.
 */

package Lesson9;

public class Main {
    public static final int SIZE = 4;
    public static String[][] strings = new String[SIZE][SIZE];

    public static void main(String[] args) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                strings[i][j] = String.valueOf(i*j);
            }

        }

        int sum = 0;

        try {
            sum = calculateSum(strings);
            System.out.println("Сумма элементов массива = " + sum);


        } catch (MyArrayDataException|MyArraySizeException e){
            System.out.println(e);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static int calculateSum(String[][] strings) throws Exception {
        return 0;
    }
}
