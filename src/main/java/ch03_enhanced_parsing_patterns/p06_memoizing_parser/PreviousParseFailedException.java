package ch03_enhanced_parsing_patterns.p06_memoizing_parser;

public class PreviousParseFailedException extends RecognitionException {
    public PreviousParseFailedException() {
        super(null);
    }
}
