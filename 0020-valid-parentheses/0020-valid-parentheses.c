bool isValid(char* s) {
    int len = strlen(s);
    
    if (len % 2 != 0) {
        return false;
    }
    char stack[len];
    int top = -1;
    for (int i = 0; i < len; i++) {
        char c = s[i];
        if (c == '(' || c == '{' || c == '[') {
            stack[++top] = c;
        }
        else {
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