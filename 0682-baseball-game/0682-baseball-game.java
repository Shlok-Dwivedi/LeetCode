class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<operations.length;i++){
            int times=0;
            if (operations[i].equals("C")){
                if(!(st.isEmpty())){
                    st.pop();
                }
            }
            else if(operations[i].equals("+")){
                int[] whatever=new int[2];
                while(times<2 && !(st.isEmpty())){
                    whatever[times]=(int)st.pop();
                    times++;
                }
                st.push(whatever[1]);
                st.push(whatever[0]);
                st.push(whatever[0]+whatever[1]);
            }
            else if(operations[i].equals("D")){
                if(!(st.isEmpty())){
                    st.push(2*st.peek());
                }
            }
            else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int sum=0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}