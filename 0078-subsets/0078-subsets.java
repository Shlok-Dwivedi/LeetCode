class Solution {
    static boolean existsInList(List<List<Integer>> ans, List<Integer> part) {
        return ans.contains(part);
    }
    private void helper(int[] nums, int index,List<Integer> current,List<List<Integer>> ans) {
        if (!existsInList(ans, current)) {
            ans.add(new ArrayList<>(current));
        }
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            helper(nums, i + 1, current, ans);
            current.remove(current.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
}