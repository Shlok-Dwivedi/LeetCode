class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, 1);
        }
        for (int num : nums2) {
            map2.put(num, 1);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                list1.add(key);
            }
        }
        for (int key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                list2.add(key);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(list1);
        ans.add(list2);

        return ans;
    }
}