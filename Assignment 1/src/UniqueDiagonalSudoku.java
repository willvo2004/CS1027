public class UniqueDiagonalSudoku extends Sudoku {
    public UniqueDiagonalSudoku (int[][] numbers) {
        super(numbers);
    }
    // {1*, 0, 0, 0, 0, 0, 0, 0, 9*},   top left - bottom right
    // {0, 5*, 0, 0, 0, 0, 0, 2*, 0},   [0][0] [1][1] [2][2] [3][3] [4][4] [5][5] [6][6] [7][7] [8][8]
    // {0, 0, 9*, 0, 0, 0, 4*, 5, 0},
    // {0, 0, 0, 5*, 0, 7*, 8, 9, 0},   bottom left - top right
    // {0, 0, 0, 0, 9*, 0, 0, 0, 0},    [8][0] [7][1] [6][2] [5][3] [4][4] [3][5] [2][6] [1][7] [0][8]
    // {0, 0, 0, 2*, 0, 4*, 0, 0, 0},
    // {0, 0, 5*, 0, 0, 0, 9*, 0, 0},
    // {0, 7*, 0, 0, 0, 0, 0, 4*, 0},
    // {9*, 0, 0, 0, 0, 0, 0, 0, 8*}
    @Override
    public boolean isValidSolution() {
        return super.isValidSolution();
    }
}