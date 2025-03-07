public class Main {
    public static void main(String[]argus){
        //Testing the matrix class
        SquareMatrix matrix = new SquareMatrix(new double[][]{{1, 4, 5,5},{5, 4, 5, 5},{5, 5, 3, 5},{5, 5, 5, 2}});
        System.out.println(matrix);

        System.out.println(matrix.getInverse());
    }
}
