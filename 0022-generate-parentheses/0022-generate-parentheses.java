class Solution {
    List<String> l1 = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper("", 0, 0, n);
        return l1;
    }

    void helper(String str, int open, int close, int n) {
        if(str.length() == 2*n) {
            l1.add(str);
            return;
        }

        if(open < n) {
            helper(str + "(", open + 1, close, n);
        }

        if(close < open) {
            helper(str + ")", open, close + 1, n);
        }
    }
}