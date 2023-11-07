public class MineEscape {

    private Map map;
    private int numGold;
    private int[] numKeys; // [red, green, blue]

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
        MapCell[] cellNeighbors = new MapCell[4];
        for (int i = 0; i < 4; i ++) {
            if (walkableCellCheck(cell)) {cellNeighbors[i] = cell.getNeighbour(i);}  // add cells to an array
        }

        int collectableCells = 0;
        int floorCells = 0;
        int lockCells = 0;
        for (int i = 0; i < cellNeighbors.length; i++) {
            if (cellNeighbors[i] != null) {

                if (cellNeighbors[i].isExit()) {
                    return cellNeighbors[i];
                }
                else if (cellNeighbors[i].isGoldCell() || cellNeighbors[i].isKeyCell()) {
                    collectableCells ++;
                }
                else if (cellNeighbors[i].isFloor()) {
                    floorCells ++;
                }
                else if (cellNeighbors[i].isLockCell()) {
                    lockCells ++;
                }
            }
        }
        if (collectableCells >= 1) {
            for (int i = 0; i < cellNeighbors.length; i++) {
                if (cellNeighbors[i] != null) {
                    if (cellNeighbors[i].isGoldCell() || cellNeighbors[i].isKeyCell()) {
                        return cellNeighbors[i]; // should return the lowest index?
                    }
                }
            }
        }
        else if (floorCells >= 1) {
            for (int i = 0; i < cellNeighbors.length; i++) {
                if (cellNeighbors[i] != null) {
                    if (cellNeighbors[i].isFloor()) {
                        return cellNeighbors[i]; // should return the lowest index?
                    }
                }
            }
        }
        else if (lockCells >= 1) {
            // do i change attribute values in this method? (Do I keep track of gold and keys?)
        }

        return null;
    }

    private boolean walkableCellCheck(MapCell cell) {
        return !(cell.isWall() && cell.isLava() && cell.isMarkedOutStack()); // is it marked in stack?
    }
}
