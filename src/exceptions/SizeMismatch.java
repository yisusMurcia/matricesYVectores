package exceptions;

/**
 * SizeMismatch
 * Exception to be thrown when the size of the vectors are different
 */
public class SizeMismatch extends RuntimeException {
    /**
     * Constructor
     */
    public SizeMismatch() {
        super("The size of the vectors are different");
    }
}
