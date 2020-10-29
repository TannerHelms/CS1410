public class LifeSimulator {
    private int X;
    private int Y;
    private boolean grid[][];

    public LifeSimulator(int sizeX, int sizeY) {
        this.X = sizeX;
        this.Y = sizeY;
        grid = new boolean[sizeX][sizeY];
    }

    public int getSizeX() {
        return X;
    }

    public int getSizeY() {
        return Y;
    }

    public boolean getCell(int x, int y) {
        return grid[x][y];
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        for (int col = 0; col < pattern.getSizeX(); col++) {
            for (int row = 0; row < pattern.getSizeY(); row++) {
                if (pattern.getCell(col, row)) {
                    grid[col + startX][row + startY] = true;
                }
            }
        }

    }

    public void update() {
        boolean board[][] = new boolean[X][Y];
        for (int col = 0; col < X; col++) {
            for (int row = 0; row < Y; row++) {
                int neighbors = countNeighbors(col, row);
                if (grid[col][row]) {
                    if (neighbors < 2) {
                        board[col][row] = false;
                    }
                    if (neighbors == 2 || neighbors == 3) {
                        board[col][row] = true;
                    }
                    if (neighbors > 3) {
                        board[col][row] = false;
                    }
                }
                if (!grid[col][row]) {
                    if (neighbors == 3) {
                        board[col][row] = true;
                    }
                }
            }
        }
        grid = board;
    }

    private boolean validPoint(int x, int y) {
        if (x < 0) {
            x = X-1;
        }else if (x == X) {
            x = 0;
        }
        if (y < 0) {
            y = Y-1;
        }else if (y == Y) {
            y = 0;
        }
        return grid[x][y];
    }

    private int countNeighbors(int x, int y) {
        int neighbors = 0;
        if (validPoint(x - 1, y - 1)) { // top left corner
            neighbors++;
        }
        if (validPoint(x - 1, y)) { // left
            neighbors++;
        }
        if (validPoint(x - 1, y + 1)) { // bottom left corner
            neighbors++;
        }
        if (validPoint(x, y - 1)) { // top
            neighbors++;
        }
        if (validPoint(x, y + 1)) { //bottom
            neighbors++;
        }

        if (validPoint(x + 1, y - 1)) { // top right corner
            neighbors++;
        }
        if (validPoint(x + 1, y)) { //right
            neighbors++;
        }
        if (validPoint(x + 1, y + 1)) { // bottom right corner
            neighbors++;
        }
        return neighbors;
    }


}