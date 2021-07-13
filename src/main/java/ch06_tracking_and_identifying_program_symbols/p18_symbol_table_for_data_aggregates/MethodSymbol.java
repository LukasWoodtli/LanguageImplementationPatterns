package ch06_tracking_and_identifying_program_symbols.p18_symbol_table_for_data_aggregates;

import java.util.LinkedHashMap;
import java.util.Map;

public class MethodSymbol extends ScopedSymbol {
    Map<String, Symbol> orderedArgs = new LinkedHashMap<String, Symbol>();

	public MethodSymbol(String name, Type retType, Scope parent) {
        super(name, retType, parent);
    }

    public Map<String, Symbol> getMembers() { return orderedArgs; }

    public String getName() {
        return name+"("+stripBrackets(orderedArgs.keySet().toString())+")";
    }
}
