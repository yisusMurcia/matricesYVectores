public class SquareMatrix  extends Matrix{


    /**
     * Constructor
     * @param size The size of the matrix
     */
    public SquareMatrix(int size){
        super(size, size);
    }

    /**
     * Constructor
     */
    public SquareMatrix(double[][] matrix) {
        super(matrix);
        if(matrix.length != matrix[0].length){
            throw new IllegalArgumentException("The matrix must be square");
        }

    }

    public static SquareMatrix getIdentityMatrix(int size){
        SquareMatrix identity = new SquareMatrix(size);
        for(int i = 0; i < size; i++){
            identity.matrix[i][i] = 1;
        }
        return identity;
    }

    /**
     * Get the determinant of the matrix
     * @return The determinant
     */
    public double getDeterminant(){
        if(getRows() == 2){
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else if (getRows() == 1) {
            return matrix[0][0];
        }
        double determinant = 0;
        for(int i = 0; i < getRows(); i++){
            determinant += Math.pow(-1, i) * matrix[0][i] * getMinor(0, i).getDeterminant();
        }
        return determinant;
    }

    /**
     * Get the minor of the matrix
     * @param row The row of the element
     * @param column The column of the element
     * @return The minor
     */
    public SquareMatrix getMinor(int row, int column){
        double[][] minor = new double[rows - 1][rows - 1];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(i != row && j != column){
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
                }
            }
        }
        return new SquareMatrix(minor);
    }

    /**
     * Pow the matrix
     * @param n The power
     */
    public void pow(int n){
        if(n == 0){
            matrix = getIdentityMatrix(rows).getMatrix();
        }
        for (int i = 1; i< n; i++){
            matrix = multiplyMatrix(this).getMatrix();
        }
    }

    /**
     * Get pow of the matrix
     * @param n The power
     * @return The result of the pow
     */
    public SquareMatrix getPow(int n){
        SquareMatrix result = new SquareMatrix(matrix);
        result.pow(n);
        return result;
    }

    /**
     * Get the matrix of the cofactors
     * @return The matrix of the cofactors
     */
    public SquareMatrix getCofactorMatrix() {
        double[][] cofactorMatrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cofactorMatrix[i][j] = Math.pow(-1, i + j) * getMinor(i, j).getDeterminant();
            }
        }
        return new SquareMatrix(cofactorMatrix);
    }

    /**
     * Get the adjoint of the matrix
     * @return The adjoint
     */
    public SquareMatrix getAdjoint(){
        return  new SquareMatrix(getCofactorMatrix().getMatrixTranspose().getMatrix());
    }

    /**
     * Get the inverse of the matrix
     * @return The inverse
     */
    public Matrix getInverse() {
        if(getDeterminant() == 0){
            throw new IllegalArgumentException("The matrix is not invertible");
        }

        return getAdjoint().getMultiplicationByScalar(1 /getDeterminant());
    }
}
