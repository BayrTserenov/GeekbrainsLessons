package Lesson8;

abstract public class Creature implements PassingBarrier{
    abstract public boolean passBarrier(Barrier barrier);
    abstract public boolean passBarrier(Barrier[] barriers);

}
