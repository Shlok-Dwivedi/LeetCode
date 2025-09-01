int divide(int dividend, int divisor) {
    if (dividend == INT_MIN && divisor == -1) {
        return INT_MAX;
    }
    if (dividend == INT_MAX && divisor == -1) {
        return 0-(INT_MIN-1);
    }
    if (dividend == INT_MIN && divisor == 1) {
        return INT_MIN;
    }
    if (dividend == INT_MAX && divisor == 1) {
        return INT_MAX;
    }
    double quo=dividend/divisor;
    if(quo==0){
        return 0;
    }
    if(quo>0){
        int i=0;
        while(i<=quo){
            i++;
        }
        return i-1;
    }
    else{
        int i=0;
        while(i>=quo){
            i--;
        }
        return i+1;
    }
}