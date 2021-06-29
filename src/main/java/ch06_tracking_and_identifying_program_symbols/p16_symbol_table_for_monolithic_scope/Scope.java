package ch06_tracking_and_identifying_program_symbols.p16_symbol_table_for_monolithic_scope;

public interface Scope {
    public String getScopeName();

    public Scope getEnclosingScope();

    public void define(Symbol sym);

    public Symbol resolve(String name);
}
