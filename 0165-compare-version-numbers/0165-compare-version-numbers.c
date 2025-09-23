#include <stdio.h>
#include <string.h>

int compareVersion(char* version1, char* version2) {
    int i = 0;
    int j = 0;
    int n1 = strlen(version1);
    int n2 = strlen(version2);

    while (i < n1 || j < n2) {
        long long v1 = 0;
        long long v2 = 0;


        while (i < n1 && version1[i] != '.') {
            v1 = v1 * 10 + (version1[i] - '0');
            i++;
        }


        while (j < n2 && version2[j] != '.') {
            v2 = v2 * 10 + (version2[j] - '0');
            j++;
        }

        if (v1 > v2) {
            return 1;
        }
        if (v1 < v2) {
            return -1;
        }

        i++;
        j++;
    }

    return 0;
}