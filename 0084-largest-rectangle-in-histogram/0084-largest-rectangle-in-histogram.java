import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        // Iterate through all bars + one extra step to flush the stack
        for (int i = 0; i <= n; i++) {
            // Use 0 height at the end to force pop remaining bars
            int h = (i == n) ? 0 : heights[i];
            
            // While current bar is shorter than stack top, calculate area
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                // Width extends from the new stack top (exclusive) to current i (exclusive)
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}   