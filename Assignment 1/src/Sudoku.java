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
        try {
            return this.grid[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    public boolean isValidRow (int row) {
        // determine if row has duplicates. Method appears to be working. Also if there are illegal digits
        try {
            int min = 1;
            int max = this.grid.length;
            int[] checker = new int[this.grid[row].length];
            int j;
            for (int i = 0; i < this.grid[row].length; i++) {
                checker[i] = this.grid[row][i];
                if (i < this.grid[row].length - 1) {
                    j = i + 1;
                } else {
                    return true;
                }
                if (checker[i] < min || checker[i] > max) {
                    return false;
                }
                while (this.grid[row][j] != checker[i] && j != this.grid[row].length - 1) {
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
        // same thing but this time use col numbers. Method seems to be working
        try {
            int min = 1;
            int max = this.grid.length;
            int[] checker = new int[this.grid.length]; // okay if every grid is a square
            int j;
            for (int i = 0; i < this.grid.length; i ++) {
                checker[i] = this.grid[i][col];
                if (i < this.grid[col].length - 1) {
                    j = i + 1;
                } else {
                    return true;
                }
                if (checker[i] < min || checker[i] > max) {
                    return false;
                }
                while (checker[i] != this.grid[j][col] && j != this.grid.length -1) {
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
            int min = 1;
            int max = this.grid.length;
            int[] boxRow = new int[9]; // assuming grid is always 3x3
            int index = 0;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
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
                if (checker[i] < min || checker[i] > max) {
                    return false;
                }
                while (j != boxRow.length - 1 && checker[i] != boxRow[j]) {
                    j ++;
                }
                if (checker[i] == boxRow[j]) {
                    return false;
                }
            }
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isValidSolution () {
        // first check rows, then check columns. If its a 9x9, then check each box
        int rowChecker = 0;
        int colChecker = 0;
        int boxChecker = 0;
        for (int i = 0; i < this.grid.length + 1; i++) {
            if (isValidRow(i)) {
                rowChecker ++;
            }
            if (isValidCol(i)) {
                colChecker ++;
            }
        }
        if (this.grid.length == 9) {
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
        if (rowChecker != this.grid.length || colChecker != this.grid.length) {
            return false;
        }
        return true;
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
        for (int i = 0; i < this.grid.length; i ++) {
            digits = digits + "\n";
            for (int j = 0; j < this.grid[i].length; j ++) {
                digits += this.grid[i][j] + " ";

            }
        }
        return digits.strip();
    }

}