class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            if (freq.containsKey(num)) {
                int currentCount = freq.get(num);
                freq.put(num, currentCount + 1);
            } else {
                freq.put(num, 1);
            }
        }
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int count : freq.values()) {
            if (seen.containsKey(count)) {
                return false;
            }
            seen.put(count, 1);
        }
        return true;
    }
}