package ch06_tracking_and_identifying_program_symbols.p17_symbol_table_for_nested_scope;

public class GlobalScope extends BaseScope {
    public GlobalScope() { super(null); }
    public String getScopeName() { return "global"; }
}
