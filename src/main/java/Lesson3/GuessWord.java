package Lesson3;
/*
2. Создать массив из слов

String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
"grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
"pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом
и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на
своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово.
Используем только маленькие буквы.

 */

import java.util.Random;
import java.util.Scanner;

public class GuessWord {


    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        String hiddenWord = "###############";//то, что мы показываем игроку после ответа
        char[] correctAnswer = generateWord(words);
        ;//агаданное слово
        char[] playerAnswer;//ответ игрока
        System.out.println("Угадайте загаданное слово, фрукт или овощ на аглийском строчными буквами. Удачи!");


        while (true) {
            System.out.println(String.valueOf(hiddenWord));
            playerAnswer = getAnswer();
            hiddenWord = showCorrectLetters(playerAnswer, correctAnswer, hiddenWord);
            if (String.valueOf(playerAnswer).equals(String.valueOf(correctAnswer))) {
                System.out.println("Вы угадали слово :" + String.valueOf(correctAnswer) + "!");
                System.exit(0);
            } else System.out.println("Ваш текущий прогресс: ");
        }
    }


    private static String showCorrectLetters(char[] playerAnswer, char[] correctAnswer, String hiddenWord) {
        int shortWordLength = correctAnswer.length;
        if (playerAnswer.length < shortWordLength) shortWordLength = playerAnswer.length;
        if (playerAnswer == null) {
            return hiddenWord;
        } else

            for (int i = 0; i < shortWordLength; i++) {
                if (correctAnswer[i] == playerAnswer[i]) {
                    hiddenWord = replace(hiddenWord, i, correctAnswer[i]);
                }
            }
        return hiddenWord;
    }


    private static char[] generateWord(String[] words) {
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index].toCharArray();
    }

    private static char[] getAnswer() {
        Scanner in = new Scanner(System.in);
        return in.next().toCharArray();
    }

    public static String replace(String hiddenWord, int index, char replace) {
        if (hiddenWord == null) {
            return hiddenWord;
        } else if (index < 0 || index >= hiddenWord.length()) {
            return hiddenWord;
        }
        char[] chars = hiddenWord.toCharArray();
        chars[index] = replace;
        return String.valueOf(chars);
    }
}
