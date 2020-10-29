public class PatternGlider extends Pattern{
    private final int X = 3;
    private final int Y = 3;
    private final boolean grid [][] = new boolean [3][3];

    public PatternGlider () {
        grid[1][0]=true;
        grid [2][1]=true;
        grid[0][2]=true;
        grid[1][2]=true;
        grid[2][2]=true;
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
