import exceptions.SizeMismatch;
import java.util.Arrays;

/**
 * Vector
 * Allowing to create a vector and perform operations with it
 * @author Jesús Antonio Murcia
 */
public class Vector {
    protected int size;
    protected double[] vector;

    /**
     * Constructor
     * @param size The size of the vector
     */
    public Vector(int size) {
        this.size = size;
        this.vector = new double[size];
    }

    /**
     * Constructor
     * @param vector The vector
     */
    public Vector(double[] vector) {
        this.size = vector.length;
        this.vector = vector;
    }

    /**
     * Get a null vector of any size
     * @param size The size of the vector
     */
    public static Vector getNullVector(int size){
        double[] vector = new double[size];
        return new Vector(vector);
    }

    public int getSize() {
        return size;
    }

    public double[] getVector() {
        return vector;
    }

    /**
     * Get the magnitude of the vector
     */
    public double getMagnitud(){
        double magnitud = 0;
        for (int i = 0; i < size; i++) {
            magnitud += Math.pow(vector[i], 2);
        }

        return Math.sqrt(magnitud);
    }

    /**
     * Multiply every value of the vector by a scalar
     * @param scalar indicate the scalar to multiply the vector
     */
    public void multiplyByScalar(double scalar){
        for (int i = 0; i < size; i++) {
            vector[i] *= scalar;
        }
    }

    /**
     * Get the multiplication of the vector by a scalar
     * @param scalar indicate the scalar to multiply the vector
     * @return The result of the multiplication
     */
    public Vector getMultiplicationByScalar(double scalar){
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = vector[i] * scalar;
        }
        return new Vector(result);
    }

    /**
     * Aplly the dot product between two vectors
     * @param vector indicate the other vector to apply the dot product
     */
    public double dotProduct(Vector vector){
        double result = 0;
        if(this.size != vector.getSize()){
            throw new SizeMismatch();
        }
        for (int i = 0; i < size; i++) {
            result += this.vector[i] * vector.vector[i];
        }
        return result;
    }

    /**
     * Get the dot product of two vectors
     * @param vector indicate the other vector to apply the dot product
     * @return The result of the dot product
     */
    public Vector getDotProduct(Vector vector){
        double[] result = new double[size];
        if(this.size != vector.getSize()){
            throw new SizeMismatch();
        }
        for (int i = 0; i < size; i++) {
            result[i] = this.vector[i] * vector.vector[i];
        }
        return new Vector(result);
    }

    /**
     * Add a vector to the current vector
     * @param vector indicate the vector to add
     */
    public void addVector(Vector vector){
        if(this.size != vector.getSize()){
            throw new SizeMismatch();
        }
        for (int i = 0; i < size; i++) {
            this.vector[i] += vector.vector[i];
        }
    }

    /**
     * Substract a vector to the current vector
     * @param vector indicate the vector to substract
     */
    public void substractVector(Vector vector){
        if(this.size != vector.getSize()){
            throw new SizeMismatch();
        }
        for (int i = 0; i < size; i++) {
            this.vector[i] -= vector.vector[i];
        }
    }

    /**
     * Get the sum of two vectors
     * @param vector indicate the other vector to add
     * @return The result of the sum
     */
    public Vector getSum(Vector vector) {
        double[] result = new double[size];
        if (this.size != vector.getSize()) {
            throw new SizeMismatch();
        }
        for (int i = 0; i < size; i++) {
            result[i] = this.vector[i] + vector.vector[i];
        }
        return new Vector(result);
    }

    /**
     * Get the substraction of two vectors
     * @param vector indicate the other vector to substract
     * @return The result of the substraction
     */
    public Vector getSubstraction(Vector vector) {
        double[] result = new double[size];
        if (this.size != vector.getSize()) {
            throw new SizeMismatch();
        }
        for (int i = 0; i < size; i++) {
            result[i] = this.vector[i] - vector.vector[i];
        }
        return new Vector(result);
    }

    /**
     * Get the angle between two vectors
     * @param vector indicate the other vector
     * @return The angle between the two vectors
     */
    public double getAngle(Vector vector){
        return Math.acos(this.dotProduct(vector) / (this.getMagnitud() * vector.getMagnitud()));
    }

    /**
     * Get the unit vector of the current vector
     * @return The unit vector
     */
    public Vector getUnitVector(){
        double magnitud = this.getMagnitud();
        double[] unitVector = new double[size];
        for (int i = 0; i < size; i++) {
            unitVector[i] = vector[i] / magnitud;
        }
        return new Vector(unitVector);
    }

    /**
     * Normalize the vector
     */
    public void normalizeVector(){
        double magnitud = this.getMagnitud();
        for (int i = 0; i < size; i++) {
            vector[i] /= magnitud;
        }
    }


    @Override
    public String toString() {
        return Arrays.toString(vector);
    }
}
