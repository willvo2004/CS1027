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
            if (walkableCellCheck(cell)) {
                cellNeighbors[i] = cell.getNeighbour(i); // add cells to an array
            }
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
            for (int i = 0; i < cellNeighbors.length; i++ ) {
                if (cellNeighbors[i] != null) {
                    if (cellNeighbors[i].isLockCell()) {
                        if (cellNeighbors[i].isRed() && numKeys[0] > 0) {
                            return cellNeighbors[i];
                        }
                        else if (cellNeighbors[i].isGreen() && numKeys[1] > 0) {
                            return cellNeighbors[i];
                        }
                        else if (cellNeighbors[i].isBlue() && numKeys[2] > 0) {
                            return cellNeighbors[i];
                        }
                    }
                }
            }
        }
        return null;
    }

    public String findEscapePath() {
        ArrayStack<MapCell> S = new ArrayStack<>();
        String path = "Path: ";
        S.push(map.getStart());

        boolean running = true;
        map.getStart().markInStack();

        while (!S.isEmpty() && running) {
            MapCell curr = S.peek();
            if (curr.isExit()) {
                running = false;
                // exit the loop
            }
            else if (curr.isKeyCell()) {
                if (curr.isRed()) {
                    numKeys[0] ++;
                }
                else if (curr.isGreen()) {
                    numKeys[1] ++;
                }
                else if (curr.isBlue()) {
                    numKeys[2] ++;
                }
            }
            else if (curr.isGoldCell()) {
                numGold ++;
            }
            for (int i = 0; i < 4; i ++) {
                if (curr.getNeighbour(i).isLava()) {
                    numGold = 0;
                }
            }
            MapCell next = findNextCell(curr);
            if (next == null) {
                curr = S.pop();
                curr.markInStack();
            }
            else {
                path += next.getID() + " ";
                S.push(next);
                next.markInStack();
                if (next.isLockCell()) {
                    int color = next.isRed() ? 0 : next.isGreen() ? 1 : next.isBlue() ? 2 : null;
                    next.changeToFloor();
                    numKeys[color] --;
                }
            }
        }
        if (!running) {
            return path; // include gold later G :
        }
        else {
            return "No solution found";
        }
    }

    private boolean walkableCellCheck(MapCell cell) {
        return !(cell.isWall() && cell.isLava() && cell.isMarked()); //
    }
}
