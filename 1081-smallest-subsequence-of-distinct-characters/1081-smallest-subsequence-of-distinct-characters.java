class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        } 
        StringBuilder stack = new StringBuilder();  
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited[c - 'a']) continue;
            while (stack.length() > 0) {
                char top = stack.charAt(stack.length() - 1);
                if (c < top && lastOccurrence[top - 'a'] > i) {
                    visited[top - 'a'] = false;
                    stack.setLength(stack.length() - 1);
                } else {
                    break;
                }
            } 
            stack.append(c);
            visited[c - 'a'] = true;
        }
        
        return stack.toString();
    }
}   