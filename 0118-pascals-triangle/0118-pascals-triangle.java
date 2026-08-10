class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> ltemp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    ltemp.add(1);
                }
                else{
                    ltemp.add(l.get(i-1).get(j-1) + l.get(i-1).get(j));
                }
            }
            l.add(ltemp);
        }
        return l;
    }
}