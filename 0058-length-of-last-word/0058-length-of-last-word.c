int lengthOfLastWord(char* s) {
    int length = strlen(s);
    int i = length - 1;
    int wordLength = 0;
    while (i >= 0 && s[i] == ' ') {
        i--;
    }
    while (i >= 0 && s[i] != ' ') {
        wordLength++;
        i--;
    }
    return wordLength;
}