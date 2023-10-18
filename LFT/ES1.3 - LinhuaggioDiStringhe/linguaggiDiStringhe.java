import java.util.Arrays;

public class linguaggiDiStringhe
{
    public static boolean scan(String s)
    {
        int state = 0;
        int i = 0;

        // Possibili ottimizzazione con aggiunta di && state != 3, concettualmente errata perchè bisogna sempre scorrere tutta la stringa
        while (state >= 0 && i < s.length()) {
            final char ch = s.charAt(i++);
            switch (state) {
                case 0:
                    if (isOdd(ch))
                        state = 1;
                    else if (isEven(ch))
                        state = 2;
                    else
                        state = -1;
                break;

                case 1:
                    if (isOdd(ch))
                        state = 1;
                    else if(isEven(ch))
                        state = 2;
                    else if(isCharBtwLZ(ch))
                        state = 4;
                    else
                        state = -1;
                break;
                case 2:
                    if (isCharBtwAK(ch))
                        state = 4;
                    else if(isOdd(ch))
                        state = 1;
                    else if(isEven(ch))
                        state = 2;
                    else
                        state = -1;
                break;
                case 4:
                    if (!isLetter(ch))
                        state = -1;
                    break;
                default: break;
            }
        }
        return state == 4;
    }

    public static void main(String[] args)
    {
        String[] arr = {
            "122Z"
        };
        for(int i = 0; i < arr.length; i++){
            if(arr[i].length() > 0){
                System.out.println(scan(arr[i]) ? "OK" : "NOPE");
            }
            else{
                System.out.println("NOPE");
            }
        }
        
    }

    public static boolean isLetter(char c){
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }

    public static boolean isNumber(char c){
        return ('0' <= c && c <= '9');
    }

    public static boolean isOdd(char c){
        return ((c - '0') % 2) != 0;
    }

    public static boolean isEven(char c){
        return ((c - '0') % 2) == 0;
    }

    public static boolean isCharBtwLZ(char c){
        return ('L' <= c && c <= 'Z') || ('l' <= c && c <= 'z');
    }

    public static boolean isCharBtwAK(char c){
        return ('A' <= c && c <= 'K') || ('a' <= c && c <= 'k');
    }
}