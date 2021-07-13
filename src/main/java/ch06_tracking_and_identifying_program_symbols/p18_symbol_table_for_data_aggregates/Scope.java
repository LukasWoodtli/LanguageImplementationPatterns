package ch06_tracking_and_identifying_program_symbols.p18_symbol_table_for_data_aggregates;

public interface Scope {
    public String getScopeName();

    /**
     * Where to look next for symbols;
     */
    public Scope getEnclosingScope();

    /**
     * Define a symbol in the current scope
     */
    public void define(Symbol sym);

    /**
     * Look up name in this scope or in enclosing scope if not here
     */
    public Symbol resolve(String name);
}
