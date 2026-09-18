class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> l=new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                l.add(grid[i][j]);
            }
        }

        for(int i=1;i<l.size();i++){
            if((l.get(i)-l.get(0))%x!=0)
                return -1;
        }

        Collections.sort(l);

        int median=l.get(l.size()/2);
        int times=0;

        for(int i=0;i<l.size();i++){
            times += Math.abs(l.get(i)-median)/x;
        }

        return times;
    }
}