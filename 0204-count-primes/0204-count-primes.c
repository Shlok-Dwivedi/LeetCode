int countPrimes(int n) {
    if (n <= 2) {
        return 0;
    }

    bool* isPrime = (bool*)malloc(n * sizeof(bool));
    memset(isPrime, true, n * sizeof(bool));

    isPrime[0] = false;
    isPrime[1] = false;

    for (int p = 2; p * p < n; p++) {
        if (isPrime[p]) {
            for (int i = p * p; i < n; i += p) {
                isPrime[i] = false;
            }
        }
    }
    int count = 0;
    for (int i = 2; i < n; i++) {
        if (isPrime[i]) {
            count++;
        }
    }
    
    free(isPrime);
    return count;
}