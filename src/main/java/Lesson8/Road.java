package Lesson8;

public class Road extends Barrier{
    PassMethod passMethod;

    public Road(int length) {
        this.size = length;
        super.passMethod = PassMethod.RUN;
    }

    public int getLength() {
        return size;
    }
}
