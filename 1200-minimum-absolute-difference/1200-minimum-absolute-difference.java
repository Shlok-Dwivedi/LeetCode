class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> l = new ArrayList<>();

        Arrays.sort(arr);

        int min_diff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            min_diff = Math.min(min_diff, diff);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == min_diff) {
                l.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return l;
    }
}