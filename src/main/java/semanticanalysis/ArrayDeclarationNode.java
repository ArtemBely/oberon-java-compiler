package semanticanalysis;

public class ArrayDeclarationNode extends AstNode {
    String arrayName;

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(int[] dimensions) {
        this.dimensions = dimensions;
    }

    public ArrayDeclarationNode(String arrayName, int[] dimensions) {
        this.arrayName = arrayName;
        this.dimensions = dimensions;
    }

    int[] dimensions;
}