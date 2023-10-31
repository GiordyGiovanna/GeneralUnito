import java.util.Arrays;

public class linguaggiDiStringhe
{
    public static boolean scan(String s)
    {
        int state = 0;
        int i = 0;

        //Assumiamo len > 0
        while (state >= 0 && i < s.length()) {
            final char ch = s.charAt(i++);
            switch (state) {
                case 0:
                    if (ch == 'a' || ch == '*')
                        state = 0;
                    else if(ch == '/')
                        state = 1;
                    else state = -1;
                break;

                case 1:
                    if (ch == 'a')
                        state = 0;
                    else if(ch == '*')
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
                    if (ch == '*')
                        state = 3;
                    else if(ch == 'a')
                        state = 2;
                    else if(ch == '/')
                        state = 0;
                    else state = -1;
                break;
                default: break;
            }
        }
        return state == 0 || state == 1;
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