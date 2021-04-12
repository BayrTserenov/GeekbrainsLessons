package Lesson2;

import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {


        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] intArray = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 1) intArray[i] = 0;
            else intArray[i] = 1;
        }
        //проверка задания 1
        System.out.print("проверка задания 1:");
        System.out.println(Arrays.toString(intArray));


        //2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] intArray2 = new int[8];
        for (int i = 0; i < 8; i += 3) {
            intArray2[i] = i;
        }
        //проверка задания 2
        System.out.print("проверка задания 2 :");
        System.out.println(Arrays.toString(intArray2));

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] intArray3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < intArray3.length; i++) {
            if (intArray3[i] < 6) intArray3[i] *= 2;
        }
        //проверка задания 3
        System.out.print("проверка задания 3 :");
        System.out.println(Arrays.toString(intArray3));


        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        /*
         *   [00 01 02 03 04 05 06]
         *   [10 11 12 13 14 15 16]
         *   [0 0 1 0 1 0 0]
         *   [0 0 0 1 0 0 0]
         *   [0 0 1 0 1 0 0]
         *   [0 1 0 0 0 1 0]
         *   [1 0 0 0 0 0 1]*/

        int[][] squareArray = new int[7][7];
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray.length; j++)
                if ((i == j) || (i + j == squareArray.length - 1)) {
                    squareArray[i][j] = 1;
                } else squareArray[i][j] = 0;
        }
        //проверка задания 4
        System.out.println("проверка задания 4 :");
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray.length; j++) {
                System.out.print(squareArray[i][j] + " ");
            }
            System.out.println();
        }


        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] intArray5 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int maxArrayInt = intArray5[0];
        int minArrayInt = intArray5[0];
        for (int i = 1; i < intArray5.length; i++) {
            if (intArray5[i] > maxArrayInt) maxArrayInt = intArray5[i];
            if (intArray5[i] < minArrayInt) minArrayInt = intArray5[i];
        }
        //проверка задания 5
        System.out.println("проверка задания 5 :");
        System.out.println("Максимальное значение = " + maxArrayInt);
        System.out.println("Минимальное значение = " + minArrayInt);

        //проверка задания 6
        int[] arrayCheckBalanced1 = {1, 9, 1, 1, 1, 5};
        int[] arrayCheckBalanced2 = {1, 3, 3, 4, 11};
        System.out.println("проверка задания 6 вариант 1:");
        System.out.println(isArrayBallanced(arrayCheckBalanced1));
        System.out.println(isArrayBallanced(arrayCheckBalanced2));
        System.out.println("проверка задания 6 вариант 2:");
        System.out.println(isArrayBallanced2(arrayCheckBalanced1));
        System.out.println(isArrayBallanced2(arrayCheckBalanced2));


        //проверка задания 7
        System.out.println("проверка задания 7 :");
        int[] arrayShift1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] arrayShift2 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] arrayShift3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] arrayShift4 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        System.out.println("n = 2");
        System.out.println("оригинальный массив: " + Arrays.toString(arrayShift1) + "\nновый массив: " + Arrays.toString(shiftArray(arrayShift1, 2)));
        System.out.println("n = -3");
        System.out.println("оригинальный массив: " + Arrays.toString(arrayShift2) + "\nновый массив: " + Arrays.toString(shiftArray(arrayShift2, -3)));
        System.out.println("n = 10 (= количеству в массиве)");
        System.out.println("оригинальный массив: " + Arrays.toString(arrayShift3) + "\nновый массив: " + Arrays.toString(shiftArray(arrayShift3, 10)));
        System.out.println("n = 0");
        System.out.println("оригинальный массив: " + Arrays.toString(arrayShift4) + "\nновый массив: " + Arrays.toString(shiftArray(arrayShift4, 0)));
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.

    public static boolean isArrayBallanced(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < array.length; i++) {
            sumLeft = sumLeft + array[i];
            for (int j = i + 1; j < array.length; j++) {
                sumRight = sumRight + array[j];
            }

            if (sumLeft == sumRight) return true;
            sumRight = 0;
        }
        return false;
    }

    public static boolean isArrayBallanced2(int[] array) {
        int sumLeft = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        if (sum % 2 == 1) return false;
        else
            for (int i = 0; i < array.length; i++) {
                sumLeft = sumLeft + array[i];
                if (sumLeft == sum / 2) return true;
            }
        return false;
    }


    //7. **** Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.

    public static int[] shiftArray(int[] array, int n) {

        int temp;
        int shiftCount;
        shiftCount = Math.abs(n % array.length);
        if (shiftCount == 0 || n == 0)
            return array;
        else if (n > 0) {
            for (int i = 0; i < shiftCount; i++) {
                temp = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = temp;
            }
        } else {
            for (int j = 0; j < shiftCount; j++) {
                temp = array[0];
                for (int i = 0; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[array.length - 1] = temp;
            }
        }
        return array;
    }


}
