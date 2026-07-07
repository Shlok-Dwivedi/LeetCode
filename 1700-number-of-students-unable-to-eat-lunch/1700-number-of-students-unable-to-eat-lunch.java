class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q=new LinkedList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=sandwiches.length-1;i>=0;i--){
            st.add(sandwiches[i]);
        }
        for(int i=0; i<students.length;i++){
            q.add(students[i]);
        }
        int consecutiveMismatch = 0;
        while((!st.isEmpty()) && (!q.isEmpty())){
            if (consecutiveMismatch == q.size()) {
                break;
            }
            int student=q.poll();
            int sandwich=st.pop();
            if(student!=sandwich){
                st.push(sandwich);
                q.add(student);
                consecutiveMismatch++;
            }
            else{
                consecutiveMismatch = 0;
            }
        }
        return q.size();
    }
}