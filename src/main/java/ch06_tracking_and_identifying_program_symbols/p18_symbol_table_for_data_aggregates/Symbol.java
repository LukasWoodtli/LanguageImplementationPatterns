package ch06_tracking_and_identifying_program_symbols.p18_symbol_table_for_data_aggregates;

public class Symbol {
    String name;
    Type type;
    Scope scope;      // All symbols know what scope contains them.

    public Symbol(String name) { this.name = name; }
    public Symbol(String name, Type type) { this(name); this.type = type; }
    public String getName() { return name; }

    public String toString() {
        String s = "";
        if ( scope!=null ) s = scope.getScopeName()+".";
        if ( type!=null ) return '<'+s+getName()+":"+type+'>';
        return s+getName();
        }

    public static String stripBrackets(String s) {
        return s.substring(1,s.length()-1);
    }
}
