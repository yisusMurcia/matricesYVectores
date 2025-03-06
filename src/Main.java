public class Main {
    public static void main(String[]argus){
        //Testing the matrix class
        Matrix matrix = new Matrix(new double[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}});
        System.out.println(matrix);

        System.out.println(matrix.multiplyMatrix(matrix.getMatrixTranspose()));
    }
}
