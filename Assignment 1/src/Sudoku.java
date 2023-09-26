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
        // determine if row has duplicates. Method appears to be working. Ask if try and catch block is needed for exception
        int[] checker = new int[this.grid[row - 1].length];
        int j;
        for (int i = 0; i < this.grid[row - 1].length; i++) {
            checker[i] = this.grid[row - 1][i];
            if (i < this.grid[row - 1].length - 1) {
                j = i + 1;
            } else {
                return true;
            }
            while (this.grid[row - 1][j] != checker[i] && j != this.grid[row - 1].length - 1) {
                j ++;
            }
            if (this.grid[row - 1][j] == checker[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidCol (int col) {
        // same thing but this time use col numbers. Method seems to be working
        int[] checker = new int[this.grid.length]; // okay if every grid is a square
        int j;
        for (int i = 0; i < this.grid.length; i ++) {
            checker[i] = this.grid[i][col - 1]; // okay
            if (i < this.grid[col - 1].length - 1) {
                j = i + 1;
            } else {
                return true;
            }
            while (checker[i] != this.grid[j][col - 1] && j != this.grid.length -1) {
                j ++;
            }
            if (this.grid[j][col - 1] == checker[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidBox (int row, int col) {
        int[] boxRow = new int[9]; // assuming grid is always 3x3
        int index = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                boxRow[index++] = this.grid[row + i][col + j]; // 3x3 grid is valid nvm this is better
            }
        }
        int[] checker = new int[boxRow.length];
        int j = 0;
        for (int i = 0; i < boxRow.length; i++) {
            checker[i] = boxRow[i];
            if (i < boxRow.length - 1) {
                j = i + 1;
            } else {
                return true;
            }
            while (j != boxRow.length - 1 && checker[i] != boxRow[j]) {
                j ++;
            }
            if (checker[i] == boxRow[j]) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidSolution () {

        return true;
    }

    public boolean equals (Sudoku other) {
        return this.grid.equals(other.getGrid());
    }

    public String toString () {
        String digits = "";
        for (int i = 0; i < this.grid.length; i ++) {
            digits = digits.strip() + "\n";
            for (int j = 0; j < this.grid[i].length; j ++) {
                digits += String.valueOf(this.grid[i][j]) + " ";

            }
        }
        return digits.strip();
    }

}