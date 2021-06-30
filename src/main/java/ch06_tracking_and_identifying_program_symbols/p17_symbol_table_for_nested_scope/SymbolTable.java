package ch06_tracking_and_identifying_program_symbols.p17_symbol_table_for_nested_scope;

import java.util.HashMap;
import java.util.Map;

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
