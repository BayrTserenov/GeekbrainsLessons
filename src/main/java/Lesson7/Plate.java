/*
1. Расширить задачу про котов и тарелки с едой
        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
        4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку

*/

package Lesson7;

public class Plate {
    private int foodCount;

    public int getFoodCapacity() {
        return foodCapacity;
    }

    public void setFoodCapacity(int foodCapacity) {
        this.foodCapacity = foodCapacity;
    }

    private int foodCapacity;

    public void putFood(int food) {
        setFoodCount(getFoodCount() + food);
        System.out.println("Положили еще "+food+" еды. ");
    }


    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }


    public Plate(int foodCount, int foodCapacity) {

        if (getFoodCapacity() < 0) {
            System.out.println("Объем тарелки должен быть от 0 и выше");
            setFoodCapacity(0);
        } else setFoodCapacity(foodCapacity);

        if (getFoodCount() < 0) {
            System.out.println("Невозможно положить отрицательное количество еды");
            setFoodCount(0);
        } else { setFoodCount(foodCount);

            if (foodCount > foodCapacity) {
                System.out.println("Нельзя положить еды больше чем влезет в тарелку");
                setFoodCount(foodCapacity);
            }
        }


    }
}
