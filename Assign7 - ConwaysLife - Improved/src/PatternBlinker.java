public class PatternBlinker extends Pattern{
    private final int X = 3;
    private final int Y = 1;
    private final boolean grid [][] = new boolean [3][1];

    public PatternBlinker () {
        grid[0][0]=true;
        grid[1][0]=true;
        grid[2][0]=true;
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
