public class myTest {
    public static void main(String[] args) {
        int[][] g1 = new int[][] {
             //  0  1  2  3  4  5  6  7
             //  *        *        *                   [0,0] [0,3] [0,6]  [3,0] [3,3] [3,6]  [6,0] [6,3] [6,6]
                {1, 2, 3, 4, 5, 6, 7, 8, 9}, // 0 *
                {4, 5, 6, 7, 8, 9, 1, 2, 3}, // 1
                {7, 8, 9, 1, 2, 3, 4, 5, 6}, // 2
                {2, 3, 4, 5, 6, 7, 8, 9, 1}, // 3 *
                {5, 6, 7, 8, 9, 1, 2, 3, 4}, // 4
                {8, 9, 1, 2, 3, 4, 5, 6, 7}, // 5
                {3, 4, 5, 6, 7, 8, 9, 1, 2}, // 6 *
                {6, 7, 8, 9, 1, 2, 3, 4, 5}, // 7
                {9, 1, 2, 3, 4, 5, 6, 7, 8}  // 8
        };
        Sudoku thing = new Sudoku(g1);
        System.out.println(thing.isValidSolution());
        //System.out.println(thing.toString());

    }
}
