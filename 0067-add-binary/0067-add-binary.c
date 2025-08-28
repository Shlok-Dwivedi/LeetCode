char* addBinary(char* a, char* b) {
    int i = strlen(a) - 1, j = strlen(b) - 1, carry = 0;
    int maxlen = (i > j ? i : j) + 3;
    char* res = (char*)malloc(maxlen);
    res[maxlen - 1] = '\0';
    int k = maxlen - 2;

    while (i >= 0 || j >= 0 || carry) {
        int sum = carry;
        if (i >= 0) sum += a[i--] - '0';
        if (j >= 0) sum += b[j--] - '0';
        res[k--] = (sum % 2) + '0';
        carry = sum / 2;
    }

    return res + k + 1; // skip leading unused part
}
