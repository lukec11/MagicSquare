/**
 * MagicSquare class, to generate Magic Squares
 *
 * @author lukec11
 * @version 0.1
*/
public class MagicSquare {
    private int size;
    private int[][] magicSquare;
  
    /**
     * Constructs a magic square of size n 
     * 
     * @param n - size of the 2D array
    */
    public MagicSquare(int n){
      int size = n; //sets size to n by default
      int[][] magicSquare = new int[size][size]; //makes 2d array of size:size
      
      if (size < 3) {
        size = 3; 
      }
      if (size % 2 != 0) {
        size +=1;
  
      }
  
      makeSquareTheRightVersion();
    }
    
    /**
     * Calls above constructor with a value of 3
     *
     */
    public MagicSquare() {
      this(3); //calls overloaded constructor with value of 3
    }
  
    /*
     * Uses de la Loubere's Algorithm to create the magic square
     *
     * @return magic square as 2D array
     */
    public void makeSquareTheRightVersion() {
      int i = 0;
      int j = size / 2;
      int n = 1;
  
      while (n <= size*size) {
        magicSquare[i][j] = n;
  
        i = (i - 1) % 3;
        j = (j + 1) % 3;
        if (magicSquare[i][j] != 0) {
          i = (i + 1) % 3;
        }
      }
    }  
    
    
    public int getSize() {
      return 3;
    }
  
    /**
     * Because every row of the magic square equals the same thing, they will all equal the same thing. Thus, I am returning the sum of the 0th row.
     * 
     * @return sum as an integer
     */
    public int getSum() {
      int sum = 0;
      for (int i = 0; i < magicSquare[0].length; i++) {
        sum +=i;
      }
      return sum;
    }
    /**
     * Checks whether the generated square is valid
     * 
     * @return boolean, true implies that the square is valid
     */
    public boolean validSquare() {
      int correctSum = getSum();
  
  
      //sum of rows
      int sumRows = 0;
      for (int i = 0; i < magicSquare.length; i++) {
        for (int j = 0; j < magicSquare[i].length; j++) {
          sumRows += magicSquare[i][j];
        }
      }
      if (sumRows != correctSum) return false;
  
      //sum of columns - similar to rows, but flipped
      int sumColumns = 0;
      for (int i = 0; i < magicSquare.length; i++) {
        for (int j = 0; j < magicSquare[i].length; j++) {
          sumColumns += magicSquare[j][i];
        }
      }
      if (sumColumns != correctSum) return false;
  
      //diagonal #1
      int sumDiagonalOne = 0;
      for (int i = 0; i < magicSquare.length; i++) {
        sumDiagonalOne += magicSquare[i][i];
      }
      if (sumDiagonalOne != correctSum) return false;
  
      //diagonal #2
      int sumDiagonalTwo = 0;
      for (int i = 0; i < magicSquare.length; i++) {
        sumDiagonalTwo = magicSquare[i][magicSquare.length-i-1];
      }
      if (sumDiagonalTwo != correctSum) return false;
  
      //assume none of the other ifs above executed
      return true;
  
  
    }
  
    /**
     * Overriden method toString, to return a compiled array
     * 
     * @return 2d array as a string
    */
    @Override
    public String toString() {
      String fin = "";
      for (int[] i : magicSquare) {
        for (int j : i) {
          fin += String.format("%03d", j) + " ";
        }
        fin += "\n";
      }
      return fin;
    }
  }