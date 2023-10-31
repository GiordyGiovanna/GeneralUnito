import java.io.*; 
import java.util.*;

public class Lexer {
    // Questo Lexer con i commenti è perfetto!
    public static int line = 1;
    private char peek = ' ';
    
    private void readch(BufferedReader br) {
        try 
        {
            peek = (char) br.read();
        } 
        catch (IOException exc) 
        {
            peek = (char) Tag.EOF; // ERROR
        }
    }

    public Token lexical_scan(BufferedReader br) {
        while (peek == ' ' || peek == '\t' || peek == '\n'  || peek == '\r') 
        {
            if (peek == '\n') line++;
            readch(br);
        }
        switch (peek) {
            case '!':
                peek = ' ';
                return Token.not;
            
            case '(':
                peek = ' ';
                return Token.lpt;

            case ')':
                peek = ' ';
                return Token.rpt;

            case '[':
                peek = ' ';
                return Token.lpq;

            case ']':
                peek = ' ';
                return Token.rpq;

            case '+':
                peek = ' ';
                return Token.plus;

            case '-':
                peek = ' ';
                return Token.minus;

            case '*':
                peek = ' ';
                return Token.mult;

            case '/':
                readch(br);
                char prev = ' ';
                if(peek == '*'){
                    readch(br);
                    prev = peek;
                    readch(br);
                    while(prev != '*' || peek != '/'){
                        prev = peek;
                        readch(br);
                    }
                    readch(br);
                    return lexical_scan(br);
                }
                else if(peek == '/'){
                    while(peek != '\n' && peek != Tag.EOF) {
                        readch(br);
                    }
                    return lexical_scan(br);
                }
                else 
                {
                    peek = ' ';
                    return Token.div;
                }

            case ';':
                peek = ' ';
                return Token.semicolon;

            case ',':
                peek = ' ';
                return Token.rpq;	

            case '&':
                readch(br);
                if (peek == '&') 
                {
                    peek = ' ';
                    return Word.and;
                }
                else 
                {
                    System.err.println("Erroneous character" + " after & : "  + peek );
                    return null;
                }

            case '|':
                readch(br);
                if (peek == '|') 
                {
                    peek = ' ';
                    return Word.or;
                }
                else 
                {
                    System.err.println("Erroneous character" + " after & : "  + peek );
                    return null;
                }
            
            case '<':
                readch(br);
                if (peek == '=') 
                {
                    peek = ' ';
                    return Word.le;
                }
                if (peek == '>') 
                {
                    peek = ' ';
                    return Word.ne;
                }
                else return Word.lt;

            case '>':
                readch(br);
                if (peek == '=') 
                {
                    peek = ' ';
                    return Word.ge;
                }
                else return Word.gt;

            case '=':
                readch(br);
                if (peek == '=') 
                {
                    peek = ' ';
                    return Word.eq;
                }
                else return null;
          
            case (char)-1:
                return new Token(Tag.EOF);

            default:
                if (Character.isLetter(peek))
                {
                    String s = "";
                    while(exitClause(peek) && Character.isLetter(peek)){
                        s += peek;
                        readch(br);
                    }
                    switch(s){
                        case "assign":
                            return Word.assign;
                        case "to":
                            return Word.to;
                        case "if":
                            return Word.iftok;
                        case "else":
                            return Word.elsetok;
                        case "do":
                            return Word.dotok;
                        case "for":
                            return Word.fortok;
                        case "begin":
                            return Word.begin;
                        case "end":
                            return Word.end;
                        case "print":
                            return Word.print;
                        case "read":
                            return Word.read;
                        case "init":
                            return Word.init;
                        default: 
                            return new NumberTok(257, s);
                    }
                } 
                else if (Character.isDigit(peek)) 
                {
                    String number = "";
                    while(exitClause(peek) && Character.isDigit(peek)){
                        number += peek;
                        readch(br);
                    }
	                return new NumberTok(256, number);
                } 
                else if(peek == '_'){
                    peek = ' ';
                    return lexical_scan(br);
                }
                else 
                {
                    System.err.println("Erroneous character: " + peek );
                    return null;
                }
        }
    }

    public static boolean exitClause(char peek){
        return peek != (char) Tag.EOF && peek != '\n' && peek != ' ';
    }
		
    public static void main(String[] args) {
        Lexer lex = new Lexer();
        String path = "text.txt"; // il percorso del file da leggere
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Token tok;
            do {
                tok = lex.lexical_scan(br);
                System.out.println("Scan: " + tok);
            } 
            while (tok.tag != Tag.EOF);
            br.close();
        } 
        catch (IOException e) {e.printStackTrace();}
    }
}
