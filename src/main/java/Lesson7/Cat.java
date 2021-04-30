/*
1. Расширить задачу про котов и тарелки с едой
        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
        4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку

*/


package Lesson7;


public class Cat {

    boolean isHungry;

    public int getStomachSize() {
        return stomachSize;
    }

    private  final int stomachSize;

    public int getEatenFood() {
        return eatenFood;
    }

    private int eatenFood;
    private int canEatMore;

    public Cat(int stomachSize) {
        if (stomachSize>=0) {
            this.isHungry = true;
            this.stomachSize = stomachSize;
            this.canEatMore = stomachSize;
        } else {System.out.println("Размер желудка должен быть от 0 и больше");
            this.stomachSize = 0;
        }
    }

    public void eat(Plate plate) {

            if (plate.getFoodCount() < canEatMore) {
                eatenFood = plate.getFoodCount();
                plate.setFoodCount(0);
                System.out.print("Мяу, хочу еще! Еда в тарелке кончилась. ");
                canEatMore = stomachSize - eatenFood;

            } else if (plate.getFoodCount() >= canEatMore) {
                eatenFood = stomachSize;
                plate.setFoodCount(plate.getFoodCount() - canEatMore);
                canEatMore = 0;
                isHungry = false;
            }

        System.out.print("Котик поел " + this.getEatenFood() + " еды. Размер его желудка: "+ this.getStomachSize()+ " еды. ");

    }
    public void sayCatIsHungry(){
        if (this.isHungry==true) System.out.print("Я еще голоден и могу съесть "+canEatMore+" еды. ");
        else System.out.println("Котик сыт. ");

    }
}




