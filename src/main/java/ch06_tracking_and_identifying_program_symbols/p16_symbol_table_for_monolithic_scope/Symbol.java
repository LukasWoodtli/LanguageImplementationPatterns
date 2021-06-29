package ch06_tracking_and_identifying_program_symbols.p16_symbol_table_for_monolithic_scope;


public class Symbol {
    String name;
    Type type;

    public Symbol(String name) {
        this.name = name;
    }
    public Symbol(String name, Type type) {
        this(name);
        this.type = type;
    }

    public String getName() { return name; }

    public String toString() {
        if (type != null) {
            return '<' + getName() + ':' + type + '>';
        }
        return getName();
    }
}
