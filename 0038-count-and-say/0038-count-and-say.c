char* countAndSay(int n) {
    char* c=(char*)malloc(5000 * sizeof(char));;
    c[0]='1';
    c[1]='\0';
    if (n==1){
        return c;
    }
    int i=2;
    while(i<=n){
        char* temp = (char*)malloc(5000 * sizeof(char));
        int k = 0;
        int len = strlen(c);

        for (int j = 0; j < len;) {
            int count = 1;
            while (j + count < len && c[j] == c[j + count]) count++;
            temp[k++] = count + '0';
            temp[k++] = c[j];
            j += count;
        }
        temp[k] = '\0';
        free(c);
        c = temp;
        
        i++;
    }
    return c;
}