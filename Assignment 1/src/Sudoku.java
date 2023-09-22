public class Sudoku {

    private int size;
    private int[][] grid;

    public Sudoku (int[][] numbers) {
        this.size = numbers.length; // grid is always a square, length of 2D array will equal length of element array
        this.grid = numbers; // shallow copy of numbers
    }

    public int getSize () {
        return this.size;
    }

    public int[][] getGrid () {
        return this.grid;
    }

    public int getDigitAt (int row, int col) {
        // try-catch block handle exception when class compiles
        try {
            return this.grid[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    public boolean isValidRow (int row) {

    }

    public boolean isValidCol (int col) {

    }

    public boolean isValidBox (int row, int col) {

    }

    public boolean isValidSolution () {

    }

    public boolean equals (Sudoku other) {

    }

    public String toString () {

    }

}