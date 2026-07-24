class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
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