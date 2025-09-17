int maxArea(int* height, int heightSize) {
    int max_area = 0;
    int left = 0;
    int right = heightSize - 1;

    while (left < right) {
        // Calculate the width
        int width = right - left;
        
        // Determine the height of the container (limited by the shorter line)
        int h = height[left] < height[right] ? height[left] : height[right];
        
        // Calculate the current area
        int current_area = width * h;
        
        // Update the maximum area if the current one is larger
        if (current_area > max_area) {
            max_area = current_area;
        }
        
        // Move the pointer that points to the shorter line
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    
    return max_area;
}