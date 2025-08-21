char* frequencySort(char* s) {
    int freq[62] = {0};
    int i = 0;

    while (s[i] != '\0') {
        char c = s[i];
        if (c >= 'a' && c <= 'z') freq[c - 'a']++;
        else if (c >= 'A' && c <= 'Z') freq[26 + (c - 'A')]++;
        else if (c >= '0' && c <= '9') freq[52 + (c - '0')]++;
        i++;
    }

    char* s1 = (char*)malloc((size_t)i + 1);
    int index = 0;

    while (1) {
        int max_value = 0, max_char = -1;
        for (int j = 0; j < 62; j++) {
            if (freq[j] > max_value) {
                max_value = freq[j];
                max_char = j;
            }
        }
        if (max_value == 0) break;

        char out;
        if (max_char < 26) out = 'a' + max_char;
        else if (max_char < 52) out = 'A' + (max_char - 26);
        else out = '0' + (max_char - 52);

        while (max_value--) s1[index++] = out;
        freq[max_char] = 0;
    }

    s1[index] = '\0';
    return s1;
}
