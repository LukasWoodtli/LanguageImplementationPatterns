package ch06_tracking_and_identifying_program_symbols.p17_symbol_table_for_nested_scope;

public class LocalScope extends BaseScope {
    public LocalScope(Scope parent) { super(parent); }
    public String getScopeName() { return "local"; }
}

