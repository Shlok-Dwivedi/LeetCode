int clumsy(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (n == 3) return 6;
    if (n == 4) return 7;
    
    int res = n * (n-1) / (n-2) + (n-3);
    n -= 4;
    
    while (n > 0) {
        if (n >= 4) {
            res = res - n * (n-1) / (n-2) + (n-3);
            n -= 4;
        } else if (n == 3) {
            res = res - n * (n-1) / (n-2);
            break;
        } else if (n == 2) {
            res = res - n * (n-1);
            break;
        } else {
            res = res - n;
            break;
        }
    }
    
    return res;
}