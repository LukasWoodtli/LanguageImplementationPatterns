package ch03_enhanced_parsing_patterns.p05_backtracking;

public class MismatchedTokenException extends RecognitionException {

	public MismatchedTokenException(String msg) {
		super(msg);
	}

}
