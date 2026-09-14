class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, Long> sum = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        long[] ans = new long[nums.length];

        for(int i=0;i<nums.length;i++){
            int x=nums[i];

            long s=sum.getOrDefault(x,0L);
            int c=count.getOrDefault(x,0);

            ans[i] += (long)i*c - s;

            sum.put(x,s+i);
            count.put(x,c+1);
        }

        sum.clear();
        count.clear();

        for(int i=nums.length-1;i>=0;i--){
            int x=nums[i];

            long s=sum.getOrDefault(x,0L);
            int c=count.getOrDefault(x,0);

            ans[i] += s - (long)i*c;

            sum.put(x,s+i);
            count.put(x,c+1);
        }

        return ans;
    }
}