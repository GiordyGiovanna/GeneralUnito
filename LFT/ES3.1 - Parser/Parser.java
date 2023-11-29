import java.io.*;

public class Parser {
    private Lexer lex;
    private BufferedReader pbr;
    private Token look;

    public Parser(Lexer l, BufferedReader br) {
        lex = l;
        pbr = br;
        move();
    }

    void move() {
        look = lex.lexical_scan(pbr);
        System.out.println("token = " + look);
    }

    void error(String s) {
	    throw new Error(s);
    }

    void match(int t) {
        if (look.tag == t) {
            if (look.tag != Tag.EOF) move();
        } else error("syntax error");
    }

    public void start() {
        if(look.tag == '(' || look.tag == 256){
            expr();
            match(Tag.EOF);
        }
        else{ error("Errore dentro start con tag: " + look.tag);} 
    }

    private void expr() {
        if(look.tag == '(' || look.tag == 256){
            term();
            exprp();            
        }
        else{ error("Errore dentro expr con tag: " + look.tag);} 
    }

    private void exprp() {
        match(look.tag);
        switch (look.tag) {
            case ')':
            case '+':            
            case '-':
                match(look.tag);
                term();
                exprp();
            break;
            case -1:
                return;
            default:
                error("Errore dentro exprp con tag: " + look.tag);        
        }
    }

    private void term() {
        if(look.tag == '(' || look.tag == 256){
            fact();
            termp();
        }
        else{error("Errore dentro term con tag: " + look.tag);}
    }

    private void termp() {
        match(look.tag);
        switch (look.tag) {
            case '*':
            case '+':
            case '-':            
            case '/':
            case ')':
                match(look.tag);
                fact();
                termp();
                break;
            case -1:
                return;
            default:
                error("Errore dentro termp con tag: " + look.tag);
            break;
        }
    }

    private void fact() {
        if(look.tag == 256 || look.tag == -1){
            return;
        }
        else if(look.tag == '('){
            match(look.tag);
            expr();
        }
        else {
            error("Errore dentro fact con tag: " + look.tag);
        }
    }
		
    public static void main(String[] args) {
        Lexer lex = new Lexer();
        String path = "text.txt"; // il percorso del file da leggere
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Parser parser = new Parser(lex, br);
            parser.start();
            System.out.println("Input OK");
            br.close();
        } catch (IOException e) {e.printStackTrace();}
    }
}