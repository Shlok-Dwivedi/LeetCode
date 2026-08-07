class Solution {
    public int diagonalSum(int[][] mat) {
        if(mat[0].length==1){
            return mat[0][0];
        }
        int sum=0;
        int j=0;
        for(int i=0;i<mat[0].length;i++){
            sum+=mat[i][i];
        }
        j=mat[0].length-1;
        for(int i=0;i<mat[0].length;i++){
            sum+=mat[i][j];
            j--;
        }
        if(mat[0].length%2!=0){
            int mid=(mat[0].length)/2;
            sum-=mat[mid][mid];
        }
        return sum;
    }
}