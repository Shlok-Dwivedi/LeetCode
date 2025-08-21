bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize, int target) {
    bool flag=false;
    for(int i=0;i<matrixSize;i++){
        for(int j=0;j<matrixColSize[i];j++){
            if  (matrix[i][j]==target){
                flag=true;
                break;
            }
        }
    }
    return flag;
}