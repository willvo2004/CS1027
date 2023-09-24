public class myTest {
    public static void main(String[] args) {
        int[][] g1 = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4}
        };
        Sudoku thing = new Sudoku(g1);
        System.out.print(thing.isValidRow(3));

    }
}
