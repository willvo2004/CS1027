/**
 * This class represents a sudoku grid. Each sudoku grid has a size n and
 * digits in each column and row between 1 and n
 * @author William Vo
 */
public class Sudoku {

    /**
     * Size of the grid
     */
    private final int size;
    /**
     * The sudoku grid
     */
    private final int[][] grid;

    /**
     * Constructor creates a sudoku grid by creating a shallow copy of numbers and
     * having a size that is equal to the length of numbers
     * @param numbers square-sudoku grid
     */
    public Sudoku (int[][] numbers) {
        this.size = numbers.length;
        this.grid = numbers;
    }

    /**
     * Getter method to access the size of the sudoku grid
     * @return size of sudoku grid
     */
    public int getSize () {
        return this.size;
    }

    /**
     * Getter method to access the sudoku grid
     * @return sudoku grid
     */
    public int[][] getGrid () {
        return this.grid;
    }

    /**
     * Getter method to access the value at a specific row and column
     * @param row row index of grid
     * @param col column index of grid
     * @return value at valid row and column, or -1 if indices are out of range
     */
    public int getDigitAt (int row, int col) {
        try {
            return this.grid[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    public boolean isValidRow (int row) {
        try {
            int j;
            int[] checker = new int[this.size];

            for (int i = 0; i < this.size; i++) {
                checker[i] = this.grid[row][i];
                if (i < this.size - 1) {
                    j = i + 1;
                } else {
                    return true;
                }
                if (checker[i] < 1 || checker[i] > this.size) {
                    return false;
                }

                while (this.grid[row][j] != checker[i] && j != this.size - 1) {
                    j ++;
                }
                if (this.grid[row][j] == checker[i]) {
                    return false;
                }
            }
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isValidCol (int col) {
        try {
            int j;
            int[] checker = new int[this.size]; // okay if every grid is a square
            for (int i = 0; i < this.size; i ++) {
                checker[i] = this.grid[i][col];
                if (i < this.size - 1) {
                    j = i + 1;
                } else {
                    return true;
                }
                if (checker[i] < 1 || checker[i] > this.size) {
                    return false;
                }

                while (checker[i] != this.grid[j][col] && j != this.size - 1) {
                    j ++;
                }
                if (this.grid[j][col] == checker[i]) {
                    return false;
                }
            }
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isValidBox (int row, int col) {
        try {
            if (row % 3 == 0 && col % 3 == 0) {
                int[] boxRow = new int[9]; // assuming grid is always 3x3
                int index = 0;

                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        boxRow[index++] = this.grid[row + i][col + j]; // 3x3 grid is valid nvm this is better
                    }
                }
                int j = 0;
                int[] checker = new int[boxRow.length];

                for (int i = 0; i < boxRow.length; i++) {
                    checker[i] = boxRow[i];
                    if (i < boxRow.length - 1) {
                        j = i + 1;
                    } else {
                        return true;
                    }
                    if (checker[i] < 1 || checker[i] > this.size) {
                        return false;
                    }

                    while (j != boxRow.length - 1 && checker[i] != boxRow[j]) {
                        j ++;
                    }
                    if (checker[i] == boxRow[j]) {
                        return false;
                    }
                }
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isValidSolution () {
        int rowChecker = 0;
        int colChecker = 0;
        int boxChecker = 0;

        for (int i = 0; i < this.size + 1; i++) {
            if (isValidRow(i)) {
                rowChecker ++;
            }
            if (isValidCol(i)) {
                colChecker ++;
            }
        }
        if (this.size == 9) {
            for (int i = 0; i < 10; i+= 3) {
                for (int j = 0; j < 10; j += 3) {
                    if (isValidBox(i,j)) {
                        boxChecker ++;
                    }
                }
            }
            if (boxChecker != 9 || colChecker != 9 || rowChecker != 9) {
                return false;
            }
        }
        return rowChecker == this.size && colChecker == this.size;
    }

    public boolean equals (Sudoku other) {
        int[][] otherGrid = other.getGrid();

        if (this.grid.length != otherGrid.length) {
            return false;
        }
        for (int i = 0; i < this.grid.length; i++) {
            if (this.grid[i].length != otherGrid[i].length) {
                return false;
            }
            for (int j = 0; j < this.grid[i].length; j++) {
                if (this.grid[i][j] != otherGrid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString () {
        String digits = "";
        for (int i = 0; i < this.size; i ++) {
            digits = digits + "\n";
            for (int j = 0; j < this.grid[i].length; j ++) {
                digits += this.grid[i][j] + " ";
            }
        }
        return digits.strip();
    }

}