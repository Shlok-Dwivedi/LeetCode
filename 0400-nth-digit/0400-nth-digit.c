int findNthDigit(int n) {
    long long len = 1;
    long long count = 9;
    long long start = 1;

    while (n > len * count) {
        n -= len * count;
        len++;
        count *= 10;
        start *= 10;
    }

    start += (n - 1) / len;

    char s[32];
    sprintf(s, "%lld", start);
    return s[(n - 1) % len] - '0';
}
