package semanticanalysis;

import exception.SemanticException;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, String> variables = new HashMap<>();

    private Map<String, Object> values = new HashMap<>();

    public boolean exists(String name) {
        return variables.containsKey(name);
    }

    public void add(String name, String type) throws SemanticException {
        if (exists(name)) {
            throw new SemanticException("Variable " + name + " is already declared.");
        }
        variables.put(name, type);
    }

    public String getType(String name) throws SemanticException {
        if (!exists(name)) {
            throw new SemanticException("Variable " + name + " is not declared.");
        }
        return variables.get(name);
    }

    public void assign(String name, Object value) throws SemanticException {
        if (!exists(name)) {
            throw new SemanticException("Variable " + name + " is not declared.");
        }
        values.put(name, value);
    }
}

