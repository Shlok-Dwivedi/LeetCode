double myPow(double x, int n) {
    if (n == 0) return 1;
    if (x == 1) return 1;

    long long m = n;
    if (m < 0) {
        x = 1 / x;
        m = -m;
    }

    double res = 1;
    while (m > 0) {
        if (m % 2 == 1) {
            res *= x;
        }
        x *= x;
        m /= 2;
    }
    return res;
}