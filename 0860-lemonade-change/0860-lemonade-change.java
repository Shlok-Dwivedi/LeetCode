class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n_fives=0;
        int n_tens=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                n_fives++;
            }
            else if(bills[i]==10){
                if(n_fives==0){
                    return false;
                }
                n_fives--;
                n_tens++;
            }
            else if(bills[i]==20){
                if(n_tens>0 && n_fives>0){
                    n_fives--;
                    n_tens--;
                }
                else if(n_fives>=3){
                    n_fives=n_fives-3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}