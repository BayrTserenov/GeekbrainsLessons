/*1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
        Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        3.У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
        плавание: кот не умеет плавать, собака 10 м.).
        4.* Добавить подсчет созданных котов, собак и животных.*/

package Lesson6;



public class Cat extends Animal {

    public static int counterCat = 0;

    public Cat() {
        counterCat++;
    }

    int maxRangetoRun = 200;


    @Override
    public void run(int range) {
        if (range < 0) System.out.println("Кот пятится назад");
        else if (range == 0) System.out.println("Кот стоит на месте, не хочет бежать");
        else if ((range > 0) && (range <= maxRangetoRun)) System.out.println("Кот пробежал " + range + " метров");
        else if (range > maxRangetoRun)
            System.out.println("Кот пробежал " + maxRangetoRun + " метров и остановился, больше он бежать не может");
    }

    @Override
    public void swim(int range) {
        System.out.println("Я не умею плавать, но могу проползти по дну " + range + " метра(ов)");
    }
}
