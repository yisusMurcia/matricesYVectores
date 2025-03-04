import exceptions.SizeMismatch;

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
     * Get the angle between two vectors
     * @param vector indicate the other vector
     * @return The angle between the two vectors
     */
    public double getAngle(Vector vector){
        return Math.acos(this.dotProduct(vector) / (this.getMagnitud() * vector.getMagnitud()));
    }
}
