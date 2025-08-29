int countNumbersWithUniqueDigits(int n) {
    int count = 0;
    int limit = 1;
    for (int i = 0; i < n; i++) limit *= 10;


    for (int i = 0; i < limit; i++) {
        int seen[10] = {0};  // track digits used
        int d = i;
        int unique = 1;

        while (d > 0) {
            int digit = d % 10;
            if (seen[digit]) {   // digit already used
                unique = 0;
                break;
            }
            seen[digit] = 1;
            d /= 10;
        }

        if (unique) count++;
    }
    return count;
}
