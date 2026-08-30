class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        char[][] chr = new char[rows][cols];
        int parser = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                chr[i][j] = encodedText.charAt(parser);
                parser++;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cols; i++) {
            int row = 0;
            int col = i;

            while (row < rows && col < cols) {
                result.append(chr[row][col]);
                row++;
                col++;
            }
        }

        while (result.length() > 0 &&
               result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }
}