class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int min=Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = nums[i];
            if (map.containsKey(complement)) {
                min=Math.min(min,i-map.get(complement));
            }
            map.put(rev(nums[i]), i);
        }
        return (min>nums.length-1?-1:min);
    }
    public int rev(int a){
        int n=a;
        int ret=0;
        while(n!=0){
            int r=n%10;
            ret=ret*10+r;
            n=n/10;
        }
        return ret;
    }
}