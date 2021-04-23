package Lesson1;



public class Main {


    // ДЗ пункт 1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {
        //проверка задания 1
        mainCheck();

        //проверка задания 2
        System.out.println("проверка задания 2");
        testVars();

        //проверка задания 3
        System.out.println("проверка задания 3");
        Float someFloat = calculateThirdPointOfHomeWork(1.0f, 2.2f, 5.9f, 3.0f);
        System.out.println("someFloat = " + someFloat);

        //проверка задания 4
        System.out.println("Проверка задания 4");
        Boolean check10and20 = isSumBetweenTenAndTwenty(7, 8);
        System.out.println(check10and20);
        check10and20 = isSumBetweenTenAndTwenty(10, 15);
        System.out.println(check10and20);

        // проверка задания 5
        System.out.println("проверка задания 5");
        printPositiveOrNegativeNumber(-4);
        printPositiveOrNegativeNumber(5);

        //проверка задания 6
        System.out.println("проверка задания 6");
        System.out.println(isNegative(4));
        System.out.println(isNegative(-8));

        //проверка задания 7
        System.out.println("проверка задания 7");
        printName("Джон");

        //проверка задания 8
        System.out.println("проверка задания 8");
        isLeapYear(-20);
        isLeapYear(1);
        isLeapYear(4);
        isLeapYear(100);
        isLeapYear(104);
        isLeapYear(400);
        isLeapYear(500);
        isLeapYear(1600);


    }

    public static void mainCheck() {
        System.out.println("Проверка задание 1. Метод Main создан");
    }

    // ДЗ пункт 2. Создать переменные всех пройденных типов данных и инициализировать их значения.

    private static void testVars() {
        byte varByte = 0;
        short varShort = 0;
        int varInt = 0;
        long varLong = 0;
        float varFloat = 0.1f;
        double varDouble = 1.0;
        char varChar = 1;
        boolean isBoolean = true;
        String varString = "Hello!";
        TestClass testClass = new TestClass(); //создал и инициализировал собственный класс.
        System.out.println("varByte = " + varByte);
        System.out.println("varShort = " + varShort);
        System.out.println("varInt = " + varInt);
        System.out.println("varLong = " + varLong);
        System.out.println("varFloat = " + varFloat);
        System.out.println("varDouble =" + varDouble);
        System.out.println("varChar = " + varChar);
        System.out.println("isBoolean =" + isBoolean);
        System.out.println("varString= " + varString);
        System.out.println("testClass" + testClass);


    }

    // ДЗ пункт 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – аргументы этого метода, имеющие тип float.

    public static float calculateThirdPointOfHomeWork(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }


    // ДЗ пункт 4. Написать метод, принимающий на вход два целых числа и проверяющий,
    // что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    public static boolean isSumBetweenTenAndTwenty(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    // ДЗ пункт 5. Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    public static void printPositiveOrNegativeNumber(int a) {
        if (a < 0) System.out.printf("Число %d является отрицательным", a);
        else System.out.printf("Число %d является положительным", a);
        System.out.println("");
    }

    // ДЗ пункт 6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное, и вернуть false если положительное.
    public static boolean isNegative(int a) {
        if (a < 0) return true;
        else return false;
    }

    // ДЗ пункт 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    public static void printName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    // ДЗ пункт 8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static void isLeapYear(int year) {
        if (year < 0)
            System.out.println("Вы ввели отрицательное значение " + year + ".\nВозможен расчет высокосных лет только нашей эры. Введите число более 0!");
        else if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
            System.out.println("Введенный год " + year + " является високосным");
        else System.out.println("Введенный год " + year + " не является високосным");
    }

    //Git


}
