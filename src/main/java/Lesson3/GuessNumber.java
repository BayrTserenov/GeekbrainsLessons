package Lesson3;

import java.util.Scanner;

/*
1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */
public class GuessNumber {
    static boolean isGameGoing = true;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        while (isGameGoing) {
            gameStart();
            playGame();
        }
    }


    private static void gameStart() {

        System.out.println("Хотите поиграть в угадайку? y - да, n - нет");
        boolean isValid = false;
        while (isValid == false) {
            String yesNo = in.next();
            if (yesNo.equals("y")) {

                isValid = true;
            } else if (yesNo.equals("n")) {
                System.exit(0);
                isValid = true;
            } else System.out.println("Неизвестная команда.\nВведите y - да, n - нет");
        }
    }

    private static void playGame() {
        System.out.println("Угадайте число от 0 до 9");
        int hiddenDigit = generateHiddenNum(10);
        int playerAnswer;
        int tryCount = 3;
        while (tryCount > 0) {
            System.out.println("Количество оставшихся попыток - " + tryCount + ". Введите ваш вариант ответа:");
            playerAnswer = getFromScanner();
            tryCount--;
            boolean isAnswerCorrect = checkAnswer(hiddenDigit, playerAnswer);
            if (isAnswerCorrect == true) {
                System.out.println("Ура! Вы ввели " + playerAnswer + " и это правильный ответ!");
                System.out.println("Вы победили!");
                break;
            } else if (tryCount == 0) {
                System.out.println("Вы исчерпали все попытки, правильный ответ был: " + hiddenDigit);
                break;
            } else if (isAnswerCorrect == false) {
                System.out.println("Попробуй еще!");
            }
        }
    }

    private static int generateHiddenNum(int n) {
        int hiddenNum = (int) (Math.random() * n);
        return hiddenNum;
    }

    private static boolean checkAnswer(int hiddenDigit, int playerAnswer) {
        if (playerAnswer < 0 && playerAnswer > 9) System.out.println("Ответ может быть только в диапазоне от 0 до 9");
        else if (playerAnswer == hiddenDigit) {
            return true;
        } else if
        (playerAnswer > hiddenDigit) {
            System.out.println("Ответ меньше, чем " + playerAnswer);
        } else if
        (playerAnswer < hiddenDigit) {
            System.out.println("Ответ больше, чем " + playerAnswer);
        }
        return false;
    }

    private static int getFromScanner() {
        int a = 0;
        boolean isValid;
        do {
            isValid = false;
            if (in.hasNextInt()) {
                a = in.nextInt();
                isValid = true;
            } else {
                in.next();
            }
        } while (!isValid);

        return a;
    }


}

