package ch03_enhanced_parsing_patterns.p06_memoizing_parser;

public abstract class RecognitionException extends Exception {
    public RecognitionException(String msg) {
	    super(msg);
    }
}
