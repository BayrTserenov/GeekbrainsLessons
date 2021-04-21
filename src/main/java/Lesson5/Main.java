
/**
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 * Создать массив из 5 сотрудников
 * <p>
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 * persArray[1] = new Person(...);
 * ...
 * persArray[4] = new Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */

package Lesson5;

public class Main {
    public static void main(String[] args) {
        StaffCredential[] staff = new StaffCredential[5];
        for (int i = 0; i < 5; i++) {
            staff[i] = new StaffCredential("name" + i, "position" + i, "email" + i,
                    "tel" + i, i * 1000, 38 + i);
        }
        System.out.println("Весь штат список:");
        for (int i = 0; i < 5; i++) {
            System.out.println(staff[i].toString());
        }

        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < 5; i++) {
            if (staff[i].age>40) System.out.println(staff[i].toString());
        }
    }


}
