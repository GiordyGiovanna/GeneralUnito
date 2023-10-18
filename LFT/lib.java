// Non compiled file used as utility storage

import java.util.Arrays;

public class lib{
    public static boolean isLetter(char c){
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }

    public static boolean isNumber(char c){
        return ('0' <= c && c <= '9');
    }

    public static boolean isOdd(char c){
        int[] arr = {1, 3, 5, 7, 9};
        return Arrays.asList(arr).contains((int)c);
    }

    public static boolean isEven(char c){
        int[] arr = {2, 4, 6, 8, 0};
        return Arrays.asList(arr).contains((int)c);
    }
}