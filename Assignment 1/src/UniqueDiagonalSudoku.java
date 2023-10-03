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

    /**
     * In addition to checking if the entire grid abides by the normal rules of Sudoku, it will
     * also check if the main diagonals of the grid abide by the same rules. A valid diagonal
     * has no duplicates and is only between 1 and size n.
     * @return True someshit
     */
    @Override
    public boolean isValidSolution() {
        if (super.isValidSolution()) {
            int k;
            int l;
            int[][] diagonalGrid = super.getGrid();
            int[] checkerTL = new int[diagonalGrid.length];
            int[] checkerBL = new int[diagonalGrid.length];
            boolean invalidArrayTL = false;
            boolean invalidArrayBL = false;
            for (int i = diagonalGrid.length - 1, j = 0; i >= 0 && (!invalidArrayTL || !invalidArrayBL); i--, j++) {
                checkerTL[j] = diagonalGrid[j][j];
                checkerBL[j] = diagonalGrid[i][j];

                if (j < diagonalGrid.length - 1 && i > 0) {
                    l = j + 1; // j = l - 1
                    k = i - 1;
                } else {
                    return true;
                }

                if ((checkerTL[j] < 1) || (checkerTL[j] > super.getSize())) {
                    invalidArrayTL = true;
                }
                if ((checkerBL[j] < 1) || (checkerTL[j] > super.getSize())) {
                    invalidArrayBL = true;
                }
                while ((l < diagonalGrid.length - 1) && (diagonalGrid[l][l] != checkerTL[j]) && (diagonalGrid[k][l] != checkerBL[j])) {
                    l ++;
                    k --;
                }

                if (diagonalGrid[l][l] == checkerTL[j]) {
                    invalidArrayTL = true;
                }
                if (diagonalGrid[k][l] == checkerBL[j]) {
                    invalidArrayBL = true;
                }

            }
            if (invalidArrayBL) {
                int j;
                for (int i = 0; i < diagonalGrid.length; i ++) {
                    checkerTL[i] = diagonalGrid[i][i];

                    if (i < diagonalGrid.length - 1) {
                        j = i + 1;
                    } else {
                        return true;
                    }
                    if (checkerTL[i] < 1 || checkerTL[i] > super.getSize()) {
                        return false;
                    }
                    while (j < diagonalGrid.length - 1 && checkerTL[i] !=  diagonalGrid[j][j]) {
                        j ++;
                    }
                     if (checkerTL[i] == diagonalGrid[j][j]) {
                         return false;
                     }
                }
            }
            if (invalidArrayTL) {
                for (int i = diagonalGrid.length - 1, j = 0; i >= 0; i--, j++ ) {
                    checkerBL[j] = diagonalGrid[i][j];
                    if (j < diagonalGrid.length - 1 && i > 0) {
                        l = j + 1;
                        k = i - 1;
                    } else {
                        return true;
                    }
                    if (checkerBL[j] < 1 || checkerBL[j] > super.getSize()) {
                        return false;
                    }
                    while (l < diagonalGrid.length - 1 && checkerBL[j] != diagonalGrid[k][l]) {
                        l ++;
                        k --;
                    }
                    if (checkerBL[j] == diagonalGrid[k][l]) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
}