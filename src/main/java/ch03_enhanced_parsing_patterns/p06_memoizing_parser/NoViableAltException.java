package ch03_enhanced_parsing_patterns.p06_memoizing_parser;

public class NoViableAltException extends RecognitionException {
    public NoViableAltException(String msg) {
        super(msg);
    }
}
