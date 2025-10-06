int lenLongestFibSubseq(int* arr, int arrSize) {
    int* index = (int*)malloc(arrSize * sizeof(int));
    
    int** dp = (int**)malloc(arrSize * sizeof(int*));
    for (int i = 0; i < arrSize; i++) {
        dp[i] = (int*)calloc(arrSize, sizeof(int));
    }
    
    int maxLen = 0;
    
    for (int k = 2; k < arrSize; k++) {
        int i = 0, j = k - 1;
        
        while (i < j) {
            long long sum = (long long)arr[i] + arr[j];
            
            if (sum < arr[k]) {
                i++;
            } else if (sum > arr[k]) {
                j--;
            } else {
                dp[j][k] = (dp[i][j] > 0) ? dp[i][j] + 1 : 3;
                
                if (dp[j][k] > maxLen) {
                    maxLen = dp[j][k];
                }
                
                i++;
                j--;
            }
        }
    }
    
    for (int i = 0; i < arrSize; i++) {
        free(dp[i]);
    }
    free(dp);
    free(index);
    
    return maxLen;
}