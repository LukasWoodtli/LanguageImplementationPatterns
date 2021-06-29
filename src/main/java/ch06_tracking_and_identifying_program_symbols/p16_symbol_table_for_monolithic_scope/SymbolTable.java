package ch06_tracking_and_identifying_program_symbols.p16_symbol_table_for_monolithic_scope;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable implements Scope {
    Map<String, Symbol> symbols = new HashMap<>();

    public SymbolTable() { initTypeSystem(); }

    protected void initTypeSystem() {
        define(new BuiltInTypeSymbol("int"));
        define(new BuiltInTypeSymbol("float"));
    }

    @Override
    public String getScopeName() {
        return "global";
    }

    @Override
    public Scope getEnclosingScope() {
        return null;
    }

    @Override
    public void define(Symbol sym) {
        symbols.put(sym.name, sym);
    }

    @Override
    public Symbol resolve(String name) {
        return symbols.get(name);
    }

    public String toString() {
        return getScopeName() + ':' + symbols;
    }
}
