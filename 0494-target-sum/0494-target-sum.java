class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Impossible to reach target
        if (Math.abs(target) > total) {
            return 0;
        }

        // target + total must be even
        if ((target + total) % 2 != 0) {
            return 0;
        }

        int targetSum = (target + total) / 2;

        int[] dp = new int[targetSum + 1];

        // One way to make sum 0: choose nothing
        dp[0] = 1;

        for (int num : nums) {

            for (int sum = targetSum; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }

        return dp[targetSum];
    }
}