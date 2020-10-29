public class GosperGlider  extends Pattern {
    private final int X = 36;
    private final int Y = 9;
    private final boolean grid[][] = new boolean[36][9];

    public GosperGlider () {
        grid[0][4] = true;
        grid[1][4] = true;
        grid[0][5] = true;
        grid[0][5] = true;
        grid[4][2] = true;
        grid[10][4] = true;
        grid[10][5] = true;
        grid[10][6] = true;
        grid[11][3] = true;
        grid[11][7] = true;
        grid[12][2] = true;
        grid[12][8] = true;
        grid[13][2] = true;
        grid[13][8] = true;
        grid[14][5] = true;
        grid[15][3] = true;
        grid[15][7] = true;
        grid[16][4] = true;
        grid[16][5] = true;
        grid[16][6] = true;
        grid[17][5] = true;
        grid[20][2] = true;
        grid[20][3] = true;
        grid[20][4] = true;
        grid[21][2] = true;
        grid[21][3] = true;
        grid[21][4] = true;
        grid[22][1] = true;
        grid[22][5] = true;
        grid[24][0] = true;
        grid[24][1] = true;
        grid[24][5] = true;
        grid[24][6] = true;
        grid[34][2] = true;
        grid[34][3] = true;
        grid[35][2] = true;
        grid[35][3] = true;

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