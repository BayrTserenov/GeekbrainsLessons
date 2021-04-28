/*1. Создать классы Собака и Кот с наследованием от класса Животное.
        2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
        Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        3.У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
        плавание: кот не умеет плавать, собака 10 м.).
        4.* Добавить подсчет созданных котов, собак и животных.*/


        package Lesson6;

public class Main {
    public static void main(String[] args) {

        Cat[] cats = new Cat[5];

        for (int i = 0; i < 5; i++) {

           cats[i] = new Cat();

        }


        cats[0].run(10);
        cats[1].run(-3);
        cats[2].run(0);
        cats[3].run(300);
        cats[4].swim(10);



        Dog[] dogs = new Dog[8];
        for (int i = 0; i < 8; i++) {
            dogs[i] = new Dog();
        }

        dogs[0].run(150);
        dogs[1].run(-3);
        dogs[2].run(0);
        dogs[3].run(6000);

        dogs[4].swim(10);
        dogs[5].swim(0);
        dogs[6].swim(30);
        dogs[7].swim(-1);

        System.out.print("Всего создано: "+Animal.counterAnimal+" Животных");
        System.out.print(", из них: ");
        System.out.print(Cat.counterCat+ " котиков");
        System.out.println(" и "+Dog.counterDog+ " песиков");

    }
}
