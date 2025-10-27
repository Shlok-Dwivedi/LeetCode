/*void rotate(int** matrix, int matrixSize, int* matrixColSize) {
    int matrixCopy[matrixSize][matrixSize];
    int mid=matrixSize/2;
    for(int i=0;i<matrixSize;i++){
        for (int j = 0; j < matrixColSize[i]; j++) {
            if(i<mid){
                matrix[i][j]=matrixCopy[n+i+1][j];
            }
        }
    }
    
}
*/
void rotate(int** matrix, int n, int* matrixColSize) {
    int temp[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            temp[j][n - 1 - i] = matrix[i][j];
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j] = temp[i][j];
        }
    }
}