class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=2) return true;
        int dx=coordinates[1][0]-coordinates[0][0];
        int dy=coordinates[1][1]-coordinates[0][1];
        for(int i=2;i<coordinates.length;i++){
            int x=coordinates[i][0]-coordinates[0][0];
            int y=coordinates[i][1]-coordinates[0][1];

            if(dx*y!=dy*x) return false;
        }
        return true;
    }
}