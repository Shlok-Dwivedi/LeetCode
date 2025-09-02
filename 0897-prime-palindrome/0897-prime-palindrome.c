bool isPalindrome(int n){
    int m=n;
    int sum=0;
    while(m!=0){
        int r=m%10;
        sum=sum*10+r;
        m=m/10;
    }
    if(n==sum){
        return true;
    }
    else{
        return false;
    }
}
bool isPrime(int k){
    if (k < 2) return false;
    if (k == 2) return true;
    if (k % 2 == 0) return false; 
    bool flag=true;
    for (int i=3;i*i<=k;i=i+2){
        if(k%i==0 && i!=k){
            flag=false;
            break;
        }
    }
    return flag;
}
int primePalindrome(int n) {
    if (n <= 2) return 2;
    int m=n;
    int i=0;
    if (m % 2 == 0) m++;
    for(i=m;i<INT_MAX;i=i+2){
        if(isPalindrome(i)){
            if(isPrime(i)){
                break;
            }
        }
    }
    return i;
}