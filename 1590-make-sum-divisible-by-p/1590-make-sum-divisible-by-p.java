class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int c = (int)(sum % p);

        if (c == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long prefix = 0;
        int min = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            int current = (int)(prefix % p);
            int target = (current - c + p) % p;

            if (map.containsKey(target)) {
                min = Math.min(min, i - map.get(target));
            }

            map.put(current, i);
        }

        return min == nums.length ? -1 : min;
    }
}