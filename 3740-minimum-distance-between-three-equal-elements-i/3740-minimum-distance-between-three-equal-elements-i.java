class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());

            List<Integer> l = map.get(nums[i]);
            l.add(i);

            if(l.size() >= 3){
                int n=l.size();
                int dist=2*(l.get(n-1)-l.get(n-3));
                ans=Math.min(ans,dist);
            }
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}