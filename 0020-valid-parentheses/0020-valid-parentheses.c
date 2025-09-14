bool isValid(char* s) {
    int len = strlen(s);
    // If the length is odd, it's impossible for all brackets to be matched.
    if (len % 2 != 0) {
        return false;
    }

    // A character array is used as a stack to keep track of open brackets.
    // The maximum possible size of the stack is the length of the string.
    char stack[len];
    int top = -1; // 'top' is the index of the top element of the stack. -1 means empty.

    // Iterate through each character in the string.
    for (int i = 0; i < len; i++) {
        char c = s[i];

        // If the character is an opening bracket, push it onto the stack.
        if (c == '(' || c == '{' || c == '[') {
            stack[++top] = c;
        }
        // If the character is a closing bracket.
        else {
            // If the stack is empty, there's no matching open bracket.
            if (top == -1) {
                return false;
            }

            // Check if the closing bracket matches the top of the stack.
            char topChar = stack[top];
            if ((c == ')' && topChar == '(') ||
                (c == '}' && topChar == '{') ||
                (c == ']' && topChar == '[')) {
                // If it matches, pop the stack.
                top--;
            } else {
                // If it doesn't match, the string is invalid.
                return false;
            }
        }
    }

    // After iterating, if the stack is empty, all brackets were correctly matched.
    // If not empty, there are unclosed open brackets.
    return top == -1;
}