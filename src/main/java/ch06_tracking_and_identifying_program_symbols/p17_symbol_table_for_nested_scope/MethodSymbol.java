package ch06_tracking_and_identifying_program_symbols.p17_symbol_table_for_nested_scope;

import java.util.LinkedHashMap;
import java.util.Map;

public class MethodSymbol extends Symbol implements Scope {
    Map<String, Symbol> orderedArgs = new LinkedHashMap<String, Symbol>();
    Scope enclosingScope;

    public MethodSymbol(String name, Type retType, Scope enclosingScope) {
        super(name, retType);
        this.enclosingScope = enclosingScope;
    }

    public Symbol resolve(String name) {
        Symbol s = orderedArgs.get(name);
        if ( s!=null ) return s;
        // if not here, check any enclosing scope
        if ( getEnclosingScope() != null ) {
            return getEnclosingScope().resolve(name);
        }
        return null; // not found
    }

    public void define(Symbol sym) {
        orderedArgs.put(sym.name, sym);
        sym.scope = this; // track the scope in each symbol
    }

    public Scope getEnclosingScope() { return enclosingScope; }
    public String getScopeName() { return name; }

    public String toString() { return "method"+super.toString()+":"+orderedArgs.values(); }
}
