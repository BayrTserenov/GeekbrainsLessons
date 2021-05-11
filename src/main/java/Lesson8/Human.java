/*      1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать
           и прыгать (методы просто выводят информацию о действии в консоль).
        2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
           соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал,
           не смог пробежать и т.д.).
        3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
        4.*У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
           Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.*/

package Lesson8;

public class Human extends Creature implements PassingBarrier {

    public static int barrierPassedHuman = 0;

    private int maxRun;
    private int maxJump;

    public Human(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }


    @Override
    public boolean passBarrier(Barrier barrier) {
        switch (barrier.passMethod) {
            case JUMP -> {
                if (barrier.size <= this.getMaxJump()) {
                    System.out.println("Але-гоп! Человек перепрыгнул стену");
                    barrierPassedHuman++;
                    return true;
                } else System.out.println("Человек не смог перепрыгнуть стену");
                ;
            }
            case RUN -> {
                if (barrier.size <= this.getMaxRun()) {
                    System.out.println("Вжик-вжик! Человек пробежал по дороге до конца");
                    barrierPassedHuman++;
                    return true;
                } else System.out.println("Человек не смог пробежать до конца");
            }
        }
        return false;
    }

    @Override
    public boolean passBarrier(Barrier[] barriers) {
        for (Barrier barrier: barriers) {
            if (!this.passBarrier(barrier)) return false;

        }
        return true;
    }
}

