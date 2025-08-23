/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** insert(int** intervals, int intervalsSize, int* intervalsColSize, int* newInterval, int newIntervalSize, int* returnSize, int** returnColumnSizes) {
    int** res = (int**)malloc((intervalsSize + 1) * sizeof(int*));
    *returnColumnSizes = (int*)malloc((intervalsSize + 1) * sizeof(int));

    int idx = 0;
    int start = newInterval[0], end = newInterval[1];
    int inserted = 0;

    for (int i = 0; i < intervalsSize; i++) {
        int curStart = intervals[i][0];
        int curEnd = intervals[i][1];

        if (curEnd < start) {
            // current interval is completely before newInterval
            res[idx] = (int*)malloc(2 * sizeof(int));
            res[idx][0] = curStart;
            res[idx][1] = curEnd;
            (*returnColumnSizes)[idx] = 2;
            idx++;
        } else if (curStart > end) {
            // current interval is completely after newInterval
            if (!inserted) {
                res[idx] = (int*)malloc(2 * sizeof(int));
                res[idx][0] = start;
                res[idx][1] = end;
                (*returnColumnSizes)[idx] = 2;
                idx++;
                inserted = 1;
            }
            res[idx] = (int*)malloc(2 * sizeof(int));
            res[idx][0] = curStart;
            res[idx][1] = curEnd;
            (*returnColumnSizes)[idx] = 2;
            idx++;
        } else {
            // overlap -> merge into newInterval
            if (curStart < start) start = curStart;
            if (curEnd > end) end = curEnd;
        }
    }

    if (!inserted) {
        res[idx] = (int*)malloc(2 * sizeof(int));
        res[idx][0] = start;
        res[idx][1] = end;
        (*returnColumnSizes)[idx] = 2;
        idx++;
    }

    *returnSize = idx;
    return res;
}