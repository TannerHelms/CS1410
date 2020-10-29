public class PatternBlock extends Pattern{
    private final int X = 2;
    private final int Y = 2;
    private final boolean grid [][] = new boolean [2][2];

    public PatternBlock () {
        grid[0][0] = true;
        grid[1][0] = true;
        grid[0][1] = true;
        grid[1][1] = true;
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
