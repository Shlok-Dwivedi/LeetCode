class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        // Give every litter a bit position
        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                litterId[i][j] = -1;

                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int allCollected = (1 << litterCount) - 1;

        // state = {row, col, remainingEnergy, mask}
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc, energy, 0});

        /*
         * visited[row][col][energy][mask]
         */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        visited[sr][sc][energy][0] = true;

        int moves = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int e = curr[2];
                int mask = curr[3];

                // All litter collected
                if (mask == allCollected) {
                    return moves;
                }

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    // Need energy to make the move
                    if (e == 0) {
                        continue;
                    }

                    int ne = e - 1;

                    // Reset energy on R
                    if (classroom[nr].charAt(nc) == 'R') {
                        ne = energy;
                    }

                    // Collect litter
                    int newMask = mask;

                    if (classroom[nr].charAt(nc) == 'L') {
                        int id = litterId[nr][nc];
                        newMask |= (1 << id);
                    }

                    if (!visited[nr][nc][ne][newMask]) {

                        visited[nr][nc][ne][newMask] = true;

                        q.offer(new int[]{
                            nr,
                            nc,
                            ne,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}