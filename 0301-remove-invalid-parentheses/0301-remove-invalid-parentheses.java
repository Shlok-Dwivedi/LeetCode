class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                left++;
            }
            else if(c == ')') {
                if(left > 0)
                    left--;
                else
                    right++;
            }
        }

        helper(s, 0, left, right, 0, new StringBuilder());

        return ans;
    }

    void helper(String s, int index, int left, int right,
                int balance, StringBuilder str) {

        if(index == s.length()) {
            if(left == 0 && right == 0 && balance == 0) {
                String res = str.toString();

                if(!ans.contains(res))
                    ans.add(res);
            }
            return;
        }

        char c = s.charAt(index);

        // Remove current character
        if(c == '(' && left > 0) {
            helper(s, index + 1, left - 1, right, balance, str);
        }

        if(c == ')' && right > 0) {
            helper(s, index + 1, left, right - 1, balance, str);
        }

        // Keep current character
        str.append(c);

        if(c == '(') {
            helper(s, index + 1, left, right, balance + 1, str);
        }
        else if(c == ')' && balance > 0) {
            helper(s, index + 1, left, right, balance - 1, str);
        }
        else if(c != '(' && c != ')') {
            helper(s, index + 1, left, right, balance, str);
        }

        str.deleteCharAt(str.length() - 1);
    }
}