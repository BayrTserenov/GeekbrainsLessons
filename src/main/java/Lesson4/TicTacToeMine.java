package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeMine {
    static final Scanner in = new Scanner(System.in);
    static int mapSize;
    static int winLineLength;

    private static final String EMPTY = " ";
    private static final String HEADER_FIRST_SYMBOL = "♥";

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static char[][] map;

    static final Random random = new Random();
    static int turnsCount = 0;
    static int numberOfTurns;
    static int lastRow;
    static int lastColumn;


    public static void main(String[] args) {

        turnGame();
    }

    private static void turnGame() {
        do {
            mapSize = getMapSize();
            map = new char[mapSize][mapSize];
            numberOfTurns = mapSize * mapSize;
            initMap();
            setMapSettings();
            printMap();
            playGame();
            endGame();

        } while (false);
    }

    private static int getMapSize() {
        int a = 0;
        System.out.println("Введите размер поля - целое число от 3 и более");
        boolean isValid;
        do {
            isValid = false;
            if (in.hasNextInt()) {
                a = in.nextInt();
                isValid = true;
                if ((a < 3)) {
                    isValid = false;
                    System.out.println("Размер поле должен быть 3 и более");
                }
            } else {
                System.out.println("Введено не целочисленное значение или текст.");
                in.next();
            }

        } while (!isValid);

        return a;
    }


    private static void initMap() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

    }

    private static void setMapSettings() {
        if (mapSize < 6) winLineLength = 3;
        else if (mapSize >= 6 && mapSize <= 10) winLineLength = 4;
        if (mapSize > 10) winLineLength = 5;
        System.out.println("Вы выбрали размер поля :" + mapSize + "х" + mapSize + "!");
        System.out.println("Условия победы : Установите в подряд " + winLineLength + " символов X по вертикали, " +
                "горизонтали или диагоняли");
    }

    private static void printMap() {
        printHeaderMap();

        printBodyMap();


    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < mapSize; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printBodyMap() {
        for (int i = 0; i < mapSize; i++) {
            printMapNumber(i);
            for (int j = 0; j < mapSize; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }


    private static void playGame() {
        do {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN, lastRow, lastColumn)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI, lastRow, lastColumn)) {
                break;
            }
        } while (true);

    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;
        boolean isInputValid;

        System.out.println("\nХод человека! Введите номера строки и столбца");
        do {
            rowNumber = -1;
            colNumber = -1;
            isInputValid = true;

            System.out.print("Строка: ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;
                lastRow = rowNumber;
            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Столбец: ");
            if (in.hasNextInt()) {
                colNumber = in.nextInt() - 1;
                lastColumn = colNumber;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }
        } while (!(isInputValid && isHumanTurnValid(rowNumber, colNumber)));

        map[rowNumber][colNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static void aiTurn() {
        int rowNumber;
        int colNumber;

        System.out.println("\nХод компуктера");
        do {
            rowNumber = random.nextInt(mapSize);
            colNumber = random.nextInt(mapSize);
        } while (!isCellFree(rowNumber, colNumber));
        map[rowNumber][colNumber] = DOT_AI;
        lastRow = rowNumber;
        lastColumn = colNumber;
        turnsCount++;
    }

    private static void processingIncorrectInput() {
        System.out.println("Ошибка ввода! Введите число в диапазоне игрового поля");
        in.next();
    }

    private static boolean isHumanTurnValid(int rowNumber, int colNumber) {
        if (!isNumberValid(rowNumber, colNumber)) {
            System.out.println("\nПроверьте значение строки и столбца");
            return false;
        }
        if (!isCellFree(rowNumber, colNumber)) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }
        return true;
    }

    private static boolean isNumberValid(int rowNumber, int colNumber) {
        return rowNumber < mapSize && rowNumber >= 0 && colNumber < mapSize && colNumber >= 0;
    }

    private static boolean isCellFree(int rowNumber, int colNumber) {
        return map[rowNumber][colNumber] == DOT_EMPTY;
    }


    private static boolean checkEnd(char symbol, int lastRow, int lastColumn) {

        if (checkWin(symbol, lastRow, lastColumn)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Ура! Вы победили!");
            } else {
                System.out.println("Восстание близко... ИИ победил");
            }
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }

        return false;
    }

    private static boolean isMapFull() {
        return turnsCount == numberOfTurns;
    }

    private static boolean checkWin(char symbol, int lastRow, int lastColumn) {
        return checkHorizontal(symbol, lastRow) ||
                checkVertical(symbol, lastColumn) ||
                checkMainDiagonal(symbol, lastRow, lastColumn) ||
                checkSideDiagonal(symbol, lastRow, lastColumn);
    }


    private static boolean checkHorizontal(char symbol, int lastRow) {
        int counter = 0;
        for (int i = 0; i < mapSize; i++) {
            if (map[lastRow][i] == symbol) {
                counter++;
                if (counter == winLineLength) return true;
            }else counter = 0;
        } return false;
    }


    private static boolean checkVertical(char symbol, int lastColumn) {
        int counter = 0;
        for (int i = 0; i < mapSize; i++) {
            if (map[i][lastColumn] == symbol) {
                counter++;
                if (counter == winLineLength) return true;
            } else counter = 0;
        }
        return false;
    }


    private static boolean checkMainDiagonal(char symbol, int lastRow, int lastColumn) {
        int startI = lastRow;
        int startJ = lastColumn;
        int counter = 0;
        int maxLength = mapSize - Math.abs(lastRow - lastColumn);
        for (int i = 0; i < mapSize; i++) {
            if ((startI == 0) || (startJ == 0)) break;
            startI--;
            startJ--;
        }

        for (int i = 0; i < maxLength; i++) {
            if (map[startI][startJ] == symbol) {
                counter++;
                if (counter == winLineLength) return true;
            } else counter = 0;

            startI++;
            startJ++;

        }
        return false;
    }


    private static boolean checkSideDiagonal(char symbol, int lastRow, int lastColumn) {
        int startI = lastRow;
        int startJ = lastColumn;
        int counter = 0;
        int indexMax = mapSize - 1;
        int maxLength = getMaxLength(lastRow, lastColumn);


        if ((lastColumn + lastRow) <= (indexMax)) {
            for (int i = 0; i < maxLength; i++) {
                if (startJ == 0) break;
                startI++;
                startJ--;

            }
        } else if ((lastColumn + lastRow) > (indexMax)) {
            for (int i = 0; i < maxLength; i++) {
                if (startI == indexMax) break;
                startI++;
                startJ--;

            }
        }

        for (int i = 0; i < maxLength; i++) {
            if (map[startI][startJ] == symbol) {
                counter++;
                if (counter == winLineLength) return true;
            } else counter = 0;
            startI--;
            startJ++;
        }
        return false;

    }

    private static int getMaxLength(int lastRow, int lastColumn) {
        int maxLength = 0;
        int indexSum = lastRow + lastColumn;
        int indexMax = mapSize - 1;
        if (indexSum <= indexMax) maxLength = lastRow + lastColumn + 1;
        else if (indexSum > indexMax) maxLength = 2 * indexMax - indexSum + 1;


        return maxLength;
    }


    private static void endGame() {
        System.exit(0);
    }

}

