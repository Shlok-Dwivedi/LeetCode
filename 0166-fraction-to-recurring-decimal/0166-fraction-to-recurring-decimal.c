char* fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
        return "0";
    }

    static char result[10001];
    char fractional_part[10001];
    
    long long num = numerator;
    long long den = denominator;

    char* p = result;
    if (num < 0 ^ den < 0) {
        *p++ = '-';
    }
    num = llabs(num);
    den = llabs(den);

    p += sprintf(p, "%lld", num / den);
    long long remainder = num % den;

    if (remainder == 0) {
        return result;
    }

    *p++ = '.';
    
    long long remainderMap[10000];
    int mapIndex = 0;
    char* f = fractional_part;

    while (remainder != 0) {
        for (int i = 0; i < mapIndex; i++) {
            if (remainderMap[i] == remainder) {
                strncpy(p, fractional_part, i);
                p += i;
                sprintf(p, "(%s)", fractional_part + i);
                return result;
            }
        }

        remainderMap[mapIndex++] = remainder;

        remainder *= 10;
        *f++ = (remainder / den) + '0';
        *f = '\0';
        remainder %= den;
    }

    sprintf(p, "%s", fractional_part);
    return result;
}