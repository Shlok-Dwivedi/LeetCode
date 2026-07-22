class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = k - 1;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max_sum = sum;

        while (end < nums.length - 1) {
            sum -= nums[start++];
            sum += nums[++end];
            max_sum = Math.max(max_sum, sum);
        }

        return (double) max_sum / k;
    }
}