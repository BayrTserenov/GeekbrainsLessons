package Lesson10;

public class Apple extends Fruit implements HasWeight{

    public static final float WEIGHT = 1f;
    public static final String TYPE = "Яблоко";

    public static String getTYPE() {
        return TYPE;
    }

    @Override
    public float getWeight() {
        return WEIGHT;
    }
}
