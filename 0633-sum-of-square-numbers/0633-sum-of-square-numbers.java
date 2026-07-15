class Solution {
    public boolean judgeSquareSum(int c) {
        List<Long> l = new ArrayList<>();
        long i = 0;
        while (i * i <= c) {
            l.add(i * i);
            i++;
        }
        int left = 0;
        int right = l.size() - 1;
        while (left <= right) {
            long sum = l.get(left) + l.get(right);
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}