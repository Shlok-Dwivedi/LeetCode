class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return n;
        }

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        int minIndex = -1;
        int maxIndex = -1;

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            if (nums[left] < minVal) {
                minVal = nums[left];
                minIndex = left;
            }

            if (nums[left] > maxVal) {
                maxVal = nums[left];
                maxIndex = left;
            }

            if (left != right) {
                if (nums[right] < minVal) {
                    minVal = nums[right];
                    minIndex = right;
                }

                if (nums[right] > maxVal) {
                    maxVal = nums[right];
                    maxIndex = right;
                }
            }

            left++;
            right--;
        }

        int first = Math.min(minIndex, maxIndex);
        int second = Math.max(minIndex, maxIndex);

        int removeFront = second + 1;

        int removeBack = n - first;

        int removeBothSides = (first + 1) + (n - second);

        return Math.min(removeFront,
                Math.min(removeBack, removeBothSides));
    }
}