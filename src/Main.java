public class Main {
    public static void main(String[]argus){
        //Testing the Vector class
        Vector vec = new Vector(new double[]{1, 2, 3});

        System.out.println("Vector: " + vec);
        System.out.println("Magnitude: " + vec.getMagnitude());
        System.out.println("Angle: " + vec.getAngle(new Vector(new double[]{1, 0, 0})));
        System.out.println("Normalized: " + vec.getUnitVector());
        System.out.println("Magnitude: " + vec.getUnitVector().getMagnitude());
        System.out.println("Angle: " + vec.getAngle(new Vector(new double[]{1, 0, 0})));
        System.out.println("Sum: " + vec.getSum(new Vector(new double[]{1, 2, 3})));
        System.out.println("Substraction: " + vec.getSubstraction(new Vector(new double[]{1, 2, 3})));
        System.out.println("Dot product: " + vec.dotProduct(new Vector(new double[]{1, 2, 3})));
        System.out.println(vec.getMagnitude()* vec.getMagnitude());
        ThreeDimensionVector vec3 = new ThreeDimensionVector(vec.getVector());
        System.out.println("Cross product: " + vec3.crossProduct(new ThreeDimensionVector(new double[]{1, 2, 3})));
    }
}
