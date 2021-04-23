/*1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
        Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        3.У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
        плавание: кот не умеет плавать, собака 10 м.).
        4.* Добавить подсчет созданных котов, собак и животных.*/

package Lesson6;

public class Dog extends Animal {
    public static int counterDog = 0;

    public Dog() {
        counterDog++;
    }

    public boolean isAbleToSwim = true;
    int maxRangetoRun = 200;
    int maxRangetoSwim = 10;

    @Override
    public void run(int range) {
        if (range < 0) System.out.println("Пес пятится назад");
        else if (range == 0) System.out.println("Пес стоит на месте, не хочет бежать");
        else if ((range > 0) && (range <= maxRangetoRun)) System.out.println("Пес пробежал " + range + " метров");
        else if (range > maxRangetoRun)
            System.out.println("Пес пробежал " + maxRangetoRun + " метров и остановился, больше он бежать не может");
    }

    @Override
    public void swim(int range) {
        if (range < 0) System.out.println("Ох уж эти твои шуточки, где ты видел, чтобы собака задом плыла?");
        else if (range == 0) System.out.println("Пес сейчас сделает буль-буль, на месте плыть неудобно");
        else if ((range > 0) && (range <= maxRangetoSwim)) System.out.println("Пес проплыл " + range + " метров");
        else if (range > maxRangetoSwim)
            System.out.println("Пес проплыл " + maxRangetoSwim + " метров и остановился, больше он плыть не может");
    }

}
