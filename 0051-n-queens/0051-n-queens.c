bool isSafe(int* cols, int row, int col) {
    for (int i = 0; i < row; i++) {
        if (cols[i] == col || abs(cols[i] - col) == abs(i - row))
            return false;
    }
    return true;
}

void backtrack(int n, int row, int* cols, char**** results, int* returnSize, int* capacity) {
    if (row == n) {
        if (*returnSize >= *capacity) {
            *capacity *= 2;
            *results = (char***)realloc(*results, (*capacity) * sizeof(char**));
        }
        
        (*results)[*returnSize] = (char**)malloc(n * sizeof(char*));
        for (int i = 0; i < n; i++) {
            (*results)[*returnSize][i] = (char*)malloc((n + 1) * sizeof(char));
            for (int j = 0; j < n; j++) {
                (*results)[*returnSize][i][j] = (j == cols[i]) ? 'Q' : '.';
            }
            (*results)[*returnSize][i][n] = '\0';
        }
        (*returnSize)++;
        return;
    }
    
    for (int col = 0; col < n; col++) {
        if (isSafe(cols, row, col)) {
            cols[row] = col;
            backtrack(n, row + 1, cols, results, returnSize, capacity);
        }
    }
}

char*** solveNQueens(int n, int* returnSize, int** returnColumnSizes) {
    *returnSize = 0;
    int capacity = 10;
    
    char*** results = (char***)malloc(capacity * sizeof(char**));
    
    int* cols = (int*)malloc(n * sizeof(int));
    
    backtrack(n, 0, cols, &results, returnSize, &capacity);
    
    *returnColumnSizes = (int*)malloc((*returnSize) * sizeof(int));
    for (int i = 0; i < *returnSize; i++) {
        (*returnColumnSizes)[i] = n;
    }
    
    free(cols);
    return results;
}