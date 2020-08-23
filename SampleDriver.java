
/**
 * Drives the Matrix class.
 * @author Arash Tabrizi
 * @version 1.0
 */
public class MatrixDriver {

    /** Constant of int type with value of 3. */
    public static final int THREE = 3;
    /** Constant of int type with value of 4. */
    public static final int FOUR = 4;
    /** Constant of int type with value of 5. */
    public static final int FIVE = 5;
    /** Constant of int type with value of 6. */
    public static final int SIX = 6;
    
    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(String[] args) {

        
        Matrix squareMatrix = new Matrix(2, 2);
        squareMatrix.setValue(2, 0, 0);
        squareMatrix.setValue(THREE, 0, 1);
        squareMatrix.setValue(FOUR, 1, 0);
        squareMatrix.setValue(FIVE, 1, 1);

        
       Matrix squareMatrix2 = new Matrix(2, 2);
       squareMatrix2.setValue(1, 0, 0);
       squareMatrix2.setValue(2, 0, 1);
       squareMatrix2.setValue(THREE, 1, 0);
       squareMatrix2.setValue(FOUR, 1, 1);

       
       System.out.println(squareMatrix.toString());
       System.out.println(squareMatrix2.toString());

       Matrix sum = squareMatrix.add(squareMatrix2);
       System.out.println(sum.toString());

       Matrix recMatrix = new Matrix(2, THREE);
       recMatrix.setValue(1, 0, 0);
       recMatrix.setValue(2, 0, 1);
       recMatrix.setValue(THREE, 0, 2);
       recMatrix.setValue(FOUR, 1, 0);
       recMatrix.setValue(FIVE, 1, 1);
       recMatrix.setValue(SIX, 1, 2);
       
       System.out.println(recMatrix.toString());
       try {
           recMatrix.add(squareMatrix);
       } catch (IllegalArgumentException e) {
           System.out.println(e);
       }
       
       System.out.println(squareMatrix2.multiply(recMatrix).toString());
       System.out.println(squareMatrix2.getDeterminant() + "is the deter");
       System.out.println(squareMatrix2.getInverse() + "is the inverse");

       try {
           System.out.println(recMatrix.multiply(squareMatrix2).toString());
       } catch (IllegalArgumentException e) {
           System.out.println(e);
       }
    }
}
