void setZeroes(int** matrix, int matrixSize, int* matrixColSize) {
    bool zero_rows[matrixSize];
    bool zero_cols[matrixColSize[0]];

    for (int i = 0; i < matrixSize; i++) zero_rows[i] = false;
    for (int j = 0; j < matrixColSize[0]; j++) zero_cols[j] = false;

    for(int i=0;i<matrixSize;i++){
        for(int j=0;j<matrixColSize[i];j++){
            if (matrix[i][j]==0){
                zero_rows[i] = true;
                zero_cols[j] = true;
            }
        }   
    }

    for(int i=0;i<matrixSize;i++){
        for(int j=0;j<matrixColSize[i];j++){
            if (zero_rows[i] || zero_cols[j]) {
                matrix[i][j] = 0;
            }
        }
    }
}