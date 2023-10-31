public class NumberTok extends Token {
	
	public NumberTok(int i){
		super(i);
	}

	public static final NumberTok 
	number = new NumberTok(256),
	identifier = new NumberTok(257); 
}
