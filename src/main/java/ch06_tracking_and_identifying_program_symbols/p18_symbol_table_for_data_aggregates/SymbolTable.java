package ch06_tracking_and_identifying_program_symbols.p18_symbol_table_for_data_aggregates;

public class SymbolTable {
    GlobalScope globals = new GlobalScope();

    public SymbolTable() { initTypeSystem(); }
    protected void initTypeSystem() {
        globals.define(new BuiltInTypeSymbol("int"));
        globals.define(new BuiltInTypeSymbol("float"));
        globals.define(new BuiltInTypeSymbol("void")); // pseudo-type
    }

    public String toString() { return globals.toString(); }
}
