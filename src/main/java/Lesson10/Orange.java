package Lesson10;

public class Orange extends Fruit implements HasWeight{

    public static final float WEIGHT = 1.5f;
    public static final String TYPE = "Апельсин";

    @Override
    public float getWeight() {
        return WEIGHT;
    }
}
