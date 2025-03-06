import exceptions.MatrixSizesIncompatible;

import java.util.Arrays;

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
     * Get a row of the matrix
     * @param row The row to get
     * @return The row vector
     */
    public Vector getRow(int row){
        if(row <= 0 || row > rows){
            throw new IllegalArgumentException("The row is out of bounds");
        }
        return new Vector(matrix[row - 1]);
    }


    /**
     * Get a column of the matrix
     * @param column The column to get
     * @return The column vector
     */
    public Vector getColumn(int column){
        if(column <= 0 || column > columns){
            throw new IllegalArgumentException("The column is out of bounds");
        }
        return getMatrixTranspose().getRow(column);//Transpose matrix and get the row
    }

    public double getValue(int row, int column){
        if(row <= 0 || row > rows || column <= 0 || column > columns){
            throw new IllegalArgumentException("The row or column is out of bounds");
        }
        return matrix[row - 1][column - 1];
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
     * Create a new matrix with the subtraction of two matrixs
     * @param matrix the matrix to subtract
     * @return The result of the subtraction
     */
    public Matrix getSubtraction(Matrix matrix){
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

    public Matrix multiplyMatrix(Matrix matrix){
        if(columns != matrix.rows){
            throw new MatrixSizesIncompatible();
        }
        double[][] result = new double[rows][matrix.columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix.columns ; j++) {
                result[i][j] = getRow(i +1).dotProduct(matrix.getColumn(j +1));
            }
        }
        return new Matrix(result);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(matrix);
    }
}
