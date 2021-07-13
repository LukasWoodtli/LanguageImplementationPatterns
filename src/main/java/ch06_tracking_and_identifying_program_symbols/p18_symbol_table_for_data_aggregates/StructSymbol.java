package ch06_tracking_and_identifying_program_symbols.p18_symbol_table_for_data_aggregates;

import java.util.LinkedHashMap;
import java.util.Map;

public class StructSymbol extends ScopedSymbol implements Type, Scope {
    Map<String, Symbol> fields = new LinkedHashMap<>();

    public StructSymbol(String name, Scope parent) {
        super(name, parent);
    }

    /** For a.b, only look in fields to resolve b, not up scope tree */
    public Symbol resolveMember(String name) { return fields.get(name); }
    public Map<String, Symbol> getMembers() { return fields; }

    public String toString() {
        return "struct " + name + ":{" + stripBrackets(fields.keySet().toString()) + "}";
    }

}
