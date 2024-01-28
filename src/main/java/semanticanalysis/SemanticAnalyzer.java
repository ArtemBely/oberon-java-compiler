package semanticanalysis;

import exception.SemanticException;
import gen.OberonBaseVisitor;
import gen.OberonParser;

import java.util.List;

public class SemanticAnalyzer extends OberonBaseVisitor<Void> {

    private SymbolTable symbolTable;

    public SemanticAnalyzer(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public Void visitVarDeclaration(OberonParser.VarDeclarationContext ctx) {
        String type = ctx.type().getText();
        List<OberonParser.IdentContext> idents = ctx.identList().ident();
        try {
            for (OberonParser.IdentContext ident : idents) {
                String varName = ident.getText();
                symbolTable.add(varName, type);
            }
        } catch (SemanticException e) {
            e.printStackTrace();
        }
        return null;
    }
}
