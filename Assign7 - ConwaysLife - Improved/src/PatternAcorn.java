public class PatternAcorn  extends Pattern {
    private final int X = 7;
    private final int Y = 3;
    private final boolean grid[][] = new boolean[7][3];

    public PatternAcorn () {
        grid[1][0] = true;
        grid[3][1] = true;
        grid[0][2] = true;
        grid[1][2] = true;
        grid[4][2] = true;
        grid[5][2] = true;
        grid[6][2] = true;

    }

    @Override
    public int getSizeX() {
        return X;
    }

    @Override
    public int getSizeY() {
        return Y;
    }

    @Override
    public boolean getCell(int x, int y) {
        return grid[x][y];
    }
}