package ch03_enhanced_parsing_patterns.p06_memoizing_parser;

public class MismatchedTokenException extends RecognitionException {
    public MismatchedTokenException(String msg) {
        super(msg);
    }
}
