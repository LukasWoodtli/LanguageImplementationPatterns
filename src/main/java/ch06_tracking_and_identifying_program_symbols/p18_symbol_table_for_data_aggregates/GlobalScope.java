package ch06_tracking_and_identifying_program_symbols.p18_symbol_table_for_data_aggregates;

public class GlobalScope extends BaseScope {
    public GlobalScope() { super(null); }
    public String getScopeName() { return "global"; }
}
