bool isSubsequence(char* s, char* t) {
    int sLen = strlen(s);
    int tLen = strlen(t);
    int j = 0;
    
    for (int i = 0; i < sLen; i++) {
        bool found = false;
        
        while (j < tLen) {
            if (s[i] == t[j]) {
                j++;
                found = true;
                break;
            }
            j++;
        }
        
        if (!found) {
            return false;
        }
    }
    
    return true;
}