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
            return this.grid[row - 1][col - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    public boolean isValidRow (int row) {
        // determine if row at index row follows rule of sudoku this method doesnt work, fix later
        int[] checker = new int[this.grid[row - 1].length];
        int j;
        for (int i = 0; i < this.grid[row].length; i++) {
            checker[i] = this.grid[row - 1][i];
            j = i + 1;
            while (j < this.grid[row - 1].length && this.grid[row - 1][j] != checker[i]) {
                j ++;
            }
            if (this.grid[row - 1][j] == checker[i]) {
                return false;
            }
        }
        return true;
    }



}