package ch06_tracking_and_identifying_program_symbols.p17_symbol_table_for_nested_scope;

public interface Scope {
    public String getScopeName();

    public Scope getEnclosingScope();

    public void define(Symbol sym);

    public Symbol resolve(String name);
}
