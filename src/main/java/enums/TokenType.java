package enums;

import types.KeyWords;
import types.LogicalOperators;
import types.SpecialSymbols;

public enum TokenType {

    VAR(KeyWords.VAR),
    ASSIGN(SpecialSymbols.ASSIGN),
    SEMI(SpecialSymbols.SEMI),
    COLON(SpecialSymbols.COLON),
    PLUS(SpecialSymbols.PLUS),
    MINUS(SpecialSymbols.MINUS),
    MULTIPLY(SpecialSymbols.MULTIPLY),
    DIVIDE(SpecialSymbols.DIVIDE),
    OR(LogicalOperators.OR),
    AND(LogicalOperators.AND),
    NOT(LogicalOperators.NOT),
    INTEGER("[0-9]+"),
    IDENTIFIER("[a-zA-Z][a-zA-Z0-9]*"),
    WHITESPACE("[ \t\r\n]+");
    public final String pattern;

    TokenType(String pattern) {
        this.pattern = pattern;
    }
}

