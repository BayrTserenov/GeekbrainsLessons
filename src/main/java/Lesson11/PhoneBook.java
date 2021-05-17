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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook implements IPhoneBook {

    private final Map<String, Set<String>> sirnameAndPhones = new TreeMap<>();


    @Override
    public void add(String sirname, String phone) {
        Set<String> phones = sirnameAndPhones.put(sirname,getPhones(phone));

    }

    @Override
    public Set<String> get(String sirname) {
        return sirnameAndPhones.get(sirname);
    }

    @Override
    public Set<String> getAllSurnames() {
        return sirnameAndPhones.keySet();
    }

    private Set<String> getPhones(String sirname) {

        Set<String> phones = sirnameAndPhones.getOrDefault(sirname, new HashSet<>());
        if (phones.isEmpty()) {
            sirnameAndPhones.put(sirname, phones);
        }
        return phones;
    }

}
