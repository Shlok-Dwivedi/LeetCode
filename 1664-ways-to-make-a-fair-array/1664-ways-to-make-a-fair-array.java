class Solution {
    public int waysToMakeFair(int[] nums) {
        int even_sum = 0;
        int odd_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even_sum += nums[i];
            } else {
                odd_sum += nums[i];
            }
        }
        int left_even = 0;
        int left_odd = 0;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even_sum -= nums[i];
            } else {
                odd_sum -= nums[i];
            }
            int new_even = left_even + odd_sum;
            int new_odd = left_odd + even_sum;

            if (new_even == new_odd) {
                ret++;
            }
            if (i % 2 == 0) {
                left_even += nums[i];
            } else {
                left_odd += nums[i];
            }
        }

        return ret;
    }
}