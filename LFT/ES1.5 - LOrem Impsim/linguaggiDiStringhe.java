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
                    if (ch == '/')
                        state = 1;
                    else
                        state = -1;
                break;

                case 1:
                    if (ch == '*')
                        state = 2;
                    else
                        state = -1;
                break;
                case 2:
                    if (ch == '/' || ch == 'a')
                        state = 2;
                    else if(ch == '*')
                        state = 3;
                    else
                        state = -1;
                break;
                case 3:
                    if (ch == 'a')
                        state = 2;
                    else if(ch == '*')
                        state = 3;
                    else if(ch == '/')
                        state = 4;
                    else state = -1;
                break;
                case 4:
                    state = -1;
                break;
                default: break;
            }
        }
        return state == 5;
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
}