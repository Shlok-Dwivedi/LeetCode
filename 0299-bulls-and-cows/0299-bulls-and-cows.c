char* getHint(char* secret, char* guess) {
    int bulls = 0, cows = 0;
    int freqS[10] = {0};
    int freqG[10] = {0};

    int n = strlen(secret);

    for (int i = 0; i < n; i++) {
        if (secret[i] == guess[i]) {
            bulls++;
        } else {
            freqS[secret[i] - '0']++;
            freqG[guess[i] - '0']++;
        }
    }

    for (int d = 0; d < 10; d++) {
        cows += (freqS[d] < freqG[d]) ? freqS[d] : freqG[d];
    }

    char* res = (char*)malloc(20 * sizeof(char));
    sprintf(res, "%dA%dB", bulls, cows);
    return res;
}