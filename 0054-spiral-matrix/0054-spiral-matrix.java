class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        HashSet<Integer> notVisited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                notVisited.add(i * cols + j);
            }
        }

        int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int d = 0;
        int i = 0;
        int j = 0;

        while (!notVisited.isEmpty()) {
            ans.add(matrix[i][j]);
            notVisited.remove(i * cols + j);

            int ni = i + dir[d][0];
            int nj = j + dir[d][1];

            if (ni < 0 || ni >= rows ||
                nj < 0 || nj >= cols ||
                !notVisited.contains(ni * cols + nj)) {
                d = (d + 1) % 4;
                ni = i + dir[d][0];
                nj = j + dir[d][1];
            }

            i = ni;
            j = nj;
        }
        return ans;
    }
}