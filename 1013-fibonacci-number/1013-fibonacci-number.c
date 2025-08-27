int fib(int n){
    if(n==0){
        return n;
    }
    int arr[n];
    for(int i=0;i<n;i++){
        if(i==0 || i==1){
            arr[i]=1;
        }
        else{
            arr[i]=arr[i-1]+arr[i-2];
        }
    }
    return arr[n-1];
}