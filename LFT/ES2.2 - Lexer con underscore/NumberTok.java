public class NumberTok extends Token {
	
	String str;
	public NumberTok(int i, String s){
		super(i);
		str = s;
	}

	public NumberTok(int i){
		super(i);
	}
	public String toString() { return "<" + tag + ", " + str + ">"; }

}
