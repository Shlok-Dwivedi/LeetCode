class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = k;

        for (int i = num.length - 1; i >= 0; i--) {
            int sum = num[i] + carry;
            result.add(0, sum % 10);
            carry = sum / 10;
        }

        while (carry > 0) {
            result.add(0, carry % 10);
            carry /= 10;
        }
        
        return result;
    }
}