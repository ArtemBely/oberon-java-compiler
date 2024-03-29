package semanticanalysis;

import org.antlr.v4.runtime.ParserRuleContext;

public class AssignmentNode extends ParserRuleContext {
    private String variableName;
    private String value;

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
