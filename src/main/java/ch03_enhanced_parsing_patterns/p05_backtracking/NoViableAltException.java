package ch03_enhanced_parsing_patterns.p05_backtracking;

public class NoViableAltException extends RecognitionException {
	public NoViableAltException(String msg) {
		super(msg);
	}

}
