#include <strings.h>
#include <stdio.h>
int strStr(char* haystack, char* needle) {
    for (int i=0;haystack[i]!='\0';i++){
        int j=0;
        while(needle[j]!=0 && haystack[i+j]==needle[j]){
            j++;
        }
        if (needle[j]=='\0'){
            return i;
        }
    }
    return -1;
}