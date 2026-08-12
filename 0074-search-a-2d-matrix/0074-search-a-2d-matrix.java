class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int left=0;
        int right=n-1;
        int row_num=Integer.MIN_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target<=matrix[mid][m-1] && target>=matrix[mid][0]){
                row_num=mid;
                break;
            }
            else if(target<matrix[mid][0]){
                right=mid-1;
            }
            else if(target>matrix[mid][m-1]){
                left=mid+1;
            }
        }
        if(row_num>=0){
            left=0;
            right=m-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if (target==matrix[row_num][mid]){
                    return true;
                }
                else if(target<matrix[row_num][mid]){
                    right=mid-1;
                }
                else if(target>matrix[row_num][mid]){
                    left=mid+1;
                }
            }
        }
        return false;
    }
}