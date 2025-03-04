/**
 * This class represents a three-dimensional vector.
 * It extends the Vector class and sets the dimension to 3 and allows the cross product.
 */

public class ThreeDimensionVector extends Vector{

    /**
     * Constructor
     * The dimension is set to 3, but the vector is not initialized
     */
    public ThreeDimensionVector() {
        super(3);
    }

    /**
     * Constructor
     * @param vector The vector, it must have a dimension of 3
     */
    public ThreeDimensionVector(double[] vector) {
        this();
        if(vector.length != 3){
            throw new IllegalArgumentException("The vector´s dimesnion must be 3");
        }
    }

    /**
     * Realice the cross product between two vectors
     * @param vector The other vector
     * @return The result of the cross product
     */
    public Vector crossProduct(ThreeDimensionVector vector){
        double[] result = new double[3];
        result[0] = this.vector[1] * vector.vector[2] - this.vector[2] * vector.vector[1];
        result[1] = this.vector[2] * vector.vector[0] - this.vector[0] * vector.vector[2];
        result[2] = this.vector[0] * vector.vector[1] - this.vector[1] * vector.vector[0];
        return new Vector(result);
    }
}
