/*
1. Необходимо написать два метода, которые делают следующее:

1) Создают одномерный длинный массив, например:
static final int size = 10000000;
static final int h = size / 2;
float[] arr = new float[size];
2) Заполняют этот массив единицами;
3) Засекают время выполнения: long a = System.currentTimeMillis();
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis();
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
Отличие первого метода от второго:
Первый просто бежит по массиву и вычисляет значения.
Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

Пример деления одного массива на два:
System.arraycopy(arr, 0, a1, 0, h);
System.arraycopy(arr, h, a2, 0, h);

Пример обратной склейки:
System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h);

Примечание:
System.arraycopy() копирует данные из одного массива в другой:
System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
По замерам времени:
Для первого метода надо считать время только на цикл расчета:
for (int i = 0; i < size; i++) {
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
}
Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

 */
package Lesson12;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }
        System.out.println("Создадим массив и проверим кусочек массива из нескольких элементов, чтобы убедиться в корректностности инициализации");
        for (int i = 122; i < 130; i++) {
            System.out.println("Элемент " + i + ": " + arr[i]);

        }
        System.out.println("Старт операции по присвоению новых значений для элементов массива...");
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Стоп. \nВремя выполнения задачи в одном потоке (мейн): " + (System.currentTimeMillis() - a) + " милисекунд.");
        System.out.println("Проверим кусочек массива из нескольких элементов, чтобы убедиться успешности операции");
        for (int i = 122; i < 130; i++) {
            System.out.println("Элемент " + i + ": " + arr[i]);
        }
        System.out.println();

        System.out.println("Поставим новую отсечку по времени");

        Long b = System.currentTimeMillis();

        System.out.println("Проверим метод пересчета массива в двух потоках...");
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Поток" + Thread.currentThread().getName() + "завершил работу");
        }, "NewThread1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a2[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Поток" + Thread.currentThread().getName() + "завершил работу");
        }, "NewThread2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);


        System.out.println("Стоп. \nВремя выполнения задачи в двух потоках: " + (System.currentTimeMillis() - b) + " милисекунд.");
        System.out.println("Проверим кусочки из двух частей массива, чтобы убедиться успешности операции");
        for (int i = 122; i < 130; i++) {
            System.out.println("Элемент " + i + ": " + arr[i]);
        }
        for (int i = 9999982; i < 9999999; i++) {
            System.out.println("Элемент " + i + ": " + arr[i]);
        }



        System.out.println("КОНЕЦ!");

    }

}
