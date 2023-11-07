public class MineEscape {

    private Map map;
    private int numGold;
    private int[] numKeys;

    public MineEscape(String filename) {
        try {
            map = new Map(filename);
            numGold = 0;
            numKeys = new int[3];

        } catch (Exception e ) {
           System.out.println(e);
        }
    }

    public MapCell findNextCell (MapCell cell) {
        for (int i = 0; i < 4; i ++) {
            if (cell.getNeighbour(i) != null) {
                if (walkableCellCheck(cell)) {

                }
            }
        }
        return null;
    }

    private boolean walkableCellCheck(MapCell cell) {
        return !(cell.isWall() && cell.isLava() && cell.isMarkedOutStack()); // is it marked in stack?
    }
}
