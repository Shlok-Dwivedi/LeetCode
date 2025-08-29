int bulbSwitch(int n) {
    if(n==0 || n==1){
        return n;
    }
    int *bulbs=calloc(n, sizeof(int));
    for (long long k = 1; k * k <= n; k++) {
        int idx = (int)(k * k) - 1;
        bulbs[idx] = !bulbs[idx];
    }
    int count=0;
    for(int i=0;i<n;i++){
        if (bulbs[i]==1){
            count++;
        }
    }
    return count;
}