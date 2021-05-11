/*      1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать
           и прыгать (методы просто выводят информацию о действии в консоль).
        2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
           соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал,
           не смог пробежать и т.д.).
        3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
        4.*У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
           Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.*/

package Lesson8;

public class Main {
    public static void main(String[] args) {
        Creature[] creatures = new Creature[3];
        creatures[0] = new Human(50, 3);
        creatures[1] = new Robot(100, 5);
        creatures[2] = new Cat(2, 2);

        Barrier[] barriers = new Barrier[8];
        barriers[0] = new Wall(1);
        barriers[1] = new Road(1);
        barriers[2] = new Wall(3);
        barriers[3] = new Road(50);
        barriers[4] = new Wall(5);
        barriers[5] = new Road(100);
        barriers[6] = new Wall(6);
        barriers[7] = new Road(106);

        for (Creature creature : creatures) {

            if (creature.passBarrier(barriers)) System.out.println("Изи препятсвие");
            else {
                System.out.println("Он выбыл");
                continue;
            }

        }
        System.out.println("Количество преодоленных человеком препятствий: " + Human.barrierPassedHuman);
        System.out.println("Количество преодоленных котиком препятствий: " + Cat.barrierPassedCat);
        System.out.println("Количество преодоленных роботом препятствий: " + Robot.barrierPassedRobot);

    }
}
