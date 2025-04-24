class Solution {
    public String intToRoman(int num) {
        // Define the mapping of values to Roman numerals
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] syb = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder romanNum = new StringBuilder();

        // Iterate over the values and symbols
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                romanNum.append(syb[i]);
                num -= val[i];
            }
        }

        return romanNum.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 3749;
        String result = solution.intToRoman(num);
        System.out.println("Roman Numeral: " + result);
    }
}
