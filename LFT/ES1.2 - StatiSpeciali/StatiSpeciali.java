public class StatiSpeciali
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
                    if (ch == '_')
                        state = 3;
                    else if (isLetter(ch))
                        state = 1;
                    else
                        state = -1;
                break;

                case 1:
                    if (isLetter(ch) || isNumber(ch) || ch == '_')
                        state = 1;
                    else
                        state = 2;
                break;
                case 3:
                    if (ch == '_')
                        state = 3;
                    else if(isLetter(ch) || isNumber(ch))
                        state = 1;
                    else
                        state = -1;
                break;
                default: break;
            }
        }
        return state == 1;
    }

    public static void main(String[] args)
    {
        if(args.length > 0){
	        System.out.println(scan(args[0]) ? "OK" : "NOPE");
        }
        else{
	        System.out.println("NOPE");
        }
    }

    public static boolean isLetter(char c){
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }

    public static boolean isNumber(char c){
        return ('0' <= c && c <= '9');
    }
}