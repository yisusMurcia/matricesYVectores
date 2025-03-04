package exceptions;

public class MatrixSizesIncompatible extends RuntimeException {
    public MatrixSizesIncompatible() {
        super("The matrix´s sizes are incompatible");
    }
}
