class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int multiple = 1;
        int index = 0;
        while (index < nums.length) {
            int target = multiple * k;
            if (nums[index] < target) {
                index++;
            } 
            else if (nums[index] == target) {
                index++;
                multiple++;
            } 
            else {
                return target;
            }
        }
        return multiple * k;
    }
}