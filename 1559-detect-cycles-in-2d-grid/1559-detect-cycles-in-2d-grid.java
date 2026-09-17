class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    if(dfs(grid, visited, i, j, -1, -1))
                        return true;
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int pi, int pj) {
        visited[i][j] = true;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if(x<0 || x>=grid.length || y<0 || y>=grid[0].length)
                continue;
            if(grid[x][y] != grid[i][j])
                continue;
            // Don't go back to the cell we just came from
            if(x==pi && y==pj)
                continue;
            // Same character + already visited = cycle
            if(visited[x][y])
                return true;
            if(dfs(grid, visited, x, y, i, j))
                return true;
        }
        return false;
    }
}