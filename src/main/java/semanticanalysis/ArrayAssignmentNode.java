package semanticanalysis;

public class ArrayAssignmentNode extends AstNode {
    String arrayName;

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayAssignmentNode(String arrayName, int[] indices, int value) {
        this.arrayName = arrayName;
        this.indices = indices;
        this.value = value;
    }

    int[] indices;
    int value;
}
