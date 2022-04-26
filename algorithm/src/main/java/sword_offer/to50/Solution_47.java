package sword_offer.to50;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)
 */
public class Solution_47 {
    public int maxValue(int[][] grid) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (x == 0 && y == 0) {
                    continue;
                }
                if (y == 0) {
                    grid[y][x] = grid[y][x - 1] + grid[y][x];
                    continue;
                }
                if (x == 0) {
                    grid[y][x] = grid[y-1][x] + grid[y][x];
                    continue;
                }
                grid[y][x] = Math.max(grid[y][x - 1], grid[y - 1][x]) + grid[y][x];
            }
        }
        int x = grid.length-1;
        int y = grid[0].length - 1;
        return grid[x][y];
    }
}