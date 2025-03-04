import exceptions.MatrixSizesIncompatible;

/**
 * Clase que representa una matriz de números.
 * @author Jesús Antonio Murcia
 */

public class Matrix {
    protected int rows;
    protected int columns;
    protected double[][] matrix;

    /**
     * Constructor
     * @param rows The number of rows
     * @param columns The number of columns
     */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }

    /**
     * Constructor
     * @param matrix The matrix
     */
    public Matrix(double[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * Get the transpose of the matrix
     * @return The transpose of the matrix
     */
    public Matrix getMatrixTranspose(){
        double[][] result = new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * Add mmtrix the product of the matrix by a scalar
     * @param matrix The matrix to add
     */
    public void add(Matrix matrix){
        if(this.rows != matrix.rows || this.columns != matrix.columns){
            throw new MatrixSizesIncompatible();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] += matrix.matrix[i][j];
            }
        }
    }

    /**
     * Substract the product of the matrix by a scalar
     * @param matrix The matrix to substract
     */
    public void substract(Matrix matrix){
        if(this.rows != matrix.rows || this.columns != matrix.columns){
            throw new MatrixSizesIncompatible();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] -= matrix.matrix[i][j];
            }
        }
    }

    /**
     * Multiply the matrix by a scalar
     * @param scalar The scalar to multiply
     */
    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] *= scalar;
            }
        }
    }

    /**
     * Create a new matrix with the sum of two matrix's
     * @param matrix The matrix to add
     * @return The result of the sum
     */
    public Matrix getAddition(Matrix matrix){
        if(this.rows != matrix.rows || this.columns != matrix.columns){
            throw new MatrixSizesIncompatible();
        }
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = this.matrix[i][j] + matrix.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * Create a new matrix with the substraction of two matrix's
     * @param matrix the matrix to substract
     * @return The result of the substraction
     */
    public Matrix getSubstraction(Matrix matrix){
        if(this.rows != matrix.rows || this.columns != matrix.columns){
            throw new MatrixSizesIncompatible();
        }
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = this.matrix[i][j] - matrix.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * Create a new matrix with the product of scalar multiplication
     * @param scalar The scalar to multiply
     * @return The result of the multiplication
     */
    public Vector getMultiplicationByScalar(double scalar){
        double[] result = new double[rows * columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i * columns + j] = matrix[i][j] * scalar;
            }
        }
        return new Vector(result);
    }

}
