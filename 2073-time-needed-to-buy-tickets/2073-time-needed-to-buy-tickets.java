class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count=0;
        Queue<Integer> q=new ArrayDeque<>();
        for(int t:tickets){
            q.add(t);
        }
        while (true) {
            int t = q.poll();
            if (k == 0 && t == 1) {
                count++;
                break;
            }
            t--;
            count++;
            if (t > 0) {
                q.add(t);
                if (k == 0) {
                    k = q.size() - 1;
                } else {
                    k--;
                }
            } else {
                if (k > 0) {
                    k--;
                }
            }
        }
        return count;
    }
}