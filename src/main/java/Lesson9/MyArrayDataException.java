package Lesson9;

import java.text.MessageFormat;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(int row, int column){
        super(MessageFormat.format("Incorrect data: cell[{0},{1}]",row,column));
    }
}
