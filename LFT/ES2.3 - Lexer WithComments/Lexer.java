import java.io.*; 
import java.util.*;

public class Lexer {

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
                peek = ' ';
                return Token.div;
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
                    while(exitClause(peek)){
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
                            return NumberTok.identifier;
                    }
                } 
                else if (Character.isDigit(peek)) 
                {
                    while(exitClause(peek) && Character.isDigit(peek)){
                        readch(br);
                    }
	                return NumberTok.number;
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
