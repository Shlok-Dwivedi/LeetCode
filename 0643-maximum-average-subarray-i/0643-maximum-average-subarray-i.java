class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int window_sum = 0;

        for (int i = 0; i < k; i++) {
            window_sum += nums[i];
        }

        int max_sum = window_sum;

        for (int i = k; i < n; i++) {
            window_sum = window_sum + nums[i] - nums[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return (double) max_sum / k;
    }
}