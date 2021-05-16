/*

2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.

Желательно как можно меньше добавлять своего, чего нет в задании
(т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес), делать взаимодействие
с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner),
тестировать просто из метода main(), прописывая add() и get().

 */
package Lesson11;

import java.util.Set;

public class Task2 {
    public static void main(String[] args) {

        IPhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов","8-926-125-1244");
        phoneBook.add("Иванов","8-926-000-1236");
        phoneBook.add("Петров","8-305-950-6597");
        phoneBook.add("Сидоров","8-911-322-6418");
        phoneBook.add("Михайлов","8-300-454-8465");
        phoneBook.add("Стасов","8-917-325-4503");
        phoneBook.add("Игогошник","8-912-121-7458");
        phoneBook.add("Свинаркин","8-916-096-3255");
        phoneBook.add("Кухарчук","8-926-000-3876");
        phoneBook.add("Мамонов","8-926-000-7454");
        phoneBook.add("Воронов","8-926-000-7441");
        phoneBook.add("Тигросян","8-926-000-1414");

        Set<String> allSurnames = phoneBook.getAllSurnames();
        for (String surname : allSurnames) {
            Set<String> phones = phoneBook.get(surname);
            System.out.printf("%s: %s%n", surname, phones);
        }
    }
    }

