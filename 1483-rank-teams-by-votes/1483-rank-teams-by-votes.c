char* rankTeams(char** votes, int votesSize) {
    int k = (int)strlen(votes[0]);

    char candidates[k + 1];
    for (int i = 0; i < k; i++) candidates[i] = votes[0][i];
    candidates[k] = '\0';

    int pos_of[26];
    for (int i = 0; i < 26; i++) pos_of[i] = -1;
    for (int i = 0; i < k; i++) pos_of[candidates[i] - 'A'] = i;

    int counts[26][26];
    for (int i = 0; i < 26; i++)
        for (int j = 0; j < 26; j++)
            counts[i][j] = 0;

    for (int i = 0; i < votesSize; i++) {
        for (int j = 0; j < k; j++) {
            int idx = pos_of[votes[i][j] - 'A'];
            counts[idx][j]++;
        }
    }

    int used[26] = {0};
    char* res = (char*)malloc((k + 1) * sizeof(char));

    for (int pos = 0; pos < k; pos++) {
        int best = -1;
        for (int i = 0; i < k; i++) {
            if (used[i]) continue;

            if (best == -1) { best = i; continue; }

            int decided = 0;
            for (int r = 0; r < k; r++) {
                if (counts[i][r] > counts[best][r]) { best = i; decided = 1; break; }
                if (counts[i][r] < counts[best][r]) { decided = 1; break; }
            }
            if (!decided) {
                if (candidates[i] < candidates[best]) best = i;
            }
        }
        res[pos] = candidates[best];
        used[best] = 1;
    }

    res[k] = '\0';
    return res;
}