
import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        grid[0][0] = 1;

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            int r = cell[0];
            int c = cell[1];
            int distance = cell[2];

            if (r == n - 1 && c == n - 1) {
                return distance;
            }

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 &&
                    nr < n && nc < n &&
                    grid[nr][nc] == 0) {

                    grid[nr][nc] = 1;
                    q.add(new int[]{nr, nc, distance + 1});
                }
            }
        }

        return -1;
    }
}
