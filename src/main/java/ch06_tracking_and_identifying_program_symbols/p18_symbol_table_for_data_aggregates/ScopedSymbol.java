package ch06_tracking_and_identifying_program_symbols.p18_symbol_table_for_data_aggregates;

import java.util.Map;

public abstract class ScopedSymbol extends Symbol implements Scope {
    Scope enclosingScope;

    public ScopedSymbol(String name, Type type, Scope enclosingScope) {
        super(name, type);
        this.enclosingScope = enclosingScope;
    }
    public ScopedSymbol(String name, Scope enclosingScope) {
        super(name);
        this.enclosingScope = enclosingScope;
    }

    public Symbol resolve(String name) {
		Symbol s = getMembers().get(name);
        if ( s!=null ) return s;
		// if not here, check any enclosing scope
		if ( getEnclosingScope() != null ) {
			return getEnclosingScope().resolve(name);
		}
		return null; // not found
	}

    public Symbol resolveType(String name) { return resolve(name); }
    
    public void define(Symbol sym) {
		getMembers().put(sym.name, sym);
		sym.scope = this; // track the scope in each symbol
	}

    public Scope getEnclosingScope() { return enclosingScope; }
    
    public String getScopeName() { return name; }

    /** Indicate how subclasses store scope members. Allows us to
     *  factor out common code in this class.
     */
    public abstract Map<String, Symbol> getMembers();
}
