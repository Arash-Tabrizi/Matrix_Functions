

/**
 * Simulates a Matrix using 2 dimensional arrays.
 * @author Arash Tabrizi
 * @version 1.0
 */
public class Matrix {

    /** Holds the matrix in 2d array. */
    private double[][] myArray;
    
    /**
     * Constructor for Matrix class.
     * @param r , row count
     * @param c , column count
     */
    public Matrix(int r, int c) {
        myArray = new double[r][c];
    }
    
    /**
     * Checks to see if matrix is square
     * @return true if square , false if not square
     */
    public boolean isSquare() {
        return this.getRow() == this.getCol();
    }
    
    /**
     * Checks to see if matrix is 2 by 2
     * @return boolean
     */
    public boolean isTwoByTwo() {
        return this.isSquare() && this.getRow() == 2;
    }
    
    /** Getter for row value. 
      * @return value for the row length
      */
    public int getRow() {
        return myArray.length;
    }
    
    /** Getter for column value.
     * @return value for the column length
     */
    public int getCol() {
        return myArray[0].length;
    }
    
    /**
     * setter for value of matrix at specified row and column.  
     * @param v , number to be set
     * @param r , row value
     * @param c , column value
     */
    public void setValue(double v, int r, int c) {
        myArray[r][c] = v;
    }
    
    /**
     * Gets the specific value from the matrix.
     * @param r , row value
     * @param c , column value
     * @return value from matrix
     */
    public double getValue(int r, int c) {
        return myArray[r][c];
    }
    
    /**
     * toString method for this class.
     * @return String concatenation of information in the method.
     */
    public String toString() {
        String data = "";
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                data += myArray[i][j] + "  ";
            }
            data += "\n";
        }
        return data;
    }
    
    /**
     * Add two matrices together.
     * @param matrix argument
     * @return sum matrix
     * @throws IllegalArgumentException , if the matrices are not compatible
     */
    public Matrix add(Matrix matrix) throws IllegalArgumentException {
        if (this.getCol() != matrix.getCol() 
                || this.getRow() != matrix.getCol()) {
            throw new IllegalArgumentException("Can not "
                    + "add matrices of diffrent size!");
        } else {
        
        Matrix addMatrix = new Matrix(this.getRow(), this.getCol());
        
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                addMatrix.setValue(this.getValue(i, j) 
                        + matrix.getValue(i, j), i, j);
            }
        }
        return addMatrix;
    }
        }
    
    /**
     * Multiply two matrices together.
     * @param matrix argument
     * @return product matrix
     * @throws IllegalArgumentException , if the matrices are not compatible
     */
    public Matrix multiply(Matrix matrix) throws IllegalArgumentException {
        if (this.getCol() != matrix.getRow()) {
            throw new IllegalArgumentException("Can not multiply matrices "
                    + "of theese dimensions!");
        } else {
            Matrix product = new Matrix(this.getRow(), matrix.getCol());
            int sum = 0;
            for (int i = 0; i < this.getRow(); i++) {
                for (int j = 0; j < matrix.getCol(); j++) {
                    for (int k = 0; k < this.getCol(); k++) { 
                    sum += this.getValue(i, k) * matrix.getValue(k, j);
                    }
                    product.setValue(sum, i, j);
                    sum = 0;

                }
            }
            return product;
        }
    }
    
    /**
     * Multiply Matrix by constant
     * @param k, constant for matrix to multiplied with
     * @return product of multiply operation
     */
    public Matrix muliplyByConstant(double k) {
        Matrix product = new Matrix(this.getRow(),this.getCol());
        for (int i = 0; i < this.getRow(); i++) {
            for (int z = 0; z < this.getCol(); z++) {
            product.setValue(k * this.getValue(i, z), i, z);
            }
        }
        return product;
    }
    
    /**
     * Determinant of a Matrix (2x2 supported)
     * @return determinant of provided matrix
     * @throws IllegalArgumentException
     */
    public double getDeterminant() throws IllegalArgumentException {
        if (!this.isSquare()){
            throw new IllegalArgumentException("This method only supports square matrices");
        } else if (!this.isTwoByTwo()) {
            throw new IllegalArgumentException("This method only supports two by two matrices");
        } else {
            return (this.getValue(0, 0) * this.getValue(1, 1)) - (this.getValue(0, 1) * this.getValue(1, 0));
        }
    }
    
    
    /**
     * Inverse of a Matrix (2x2 supported)
     * @return Inverse of given parameter
     * @throws IllegalArgumentException
     */
    public Matrix getInverse() throws IllegalArgumentException {
        if (!this.isSquare()) {
            throw new IllegalArgumentException("Matrix is not square, therefore can not be inverted");
    }
        if (this.getDeterminant() == 0) {
            throw new IllegalArgumentException("Matrix has no inverse");
        }
        
        if(this.isTwoByTwo()) {
            Matrix result = new Matrix(2,2);
            result.setValue(this.getValue(1, 1), 0, 0);
            result.setValue(-this.getValue(0, 1), 0, 1);
            result.setValue(-this.getValue(1, 0), 1, 0);
            result.setValue(this.getValue(0, 0), 1, 1);
            double constant = (1) / (this.getDeterminant());
            result = result.muliplyByConstant(constant);
            return result;
        } else {
            throw new IllegalArgumentException("Two by Two matrices are currently supported");
        }
    }
}
