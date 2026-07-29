class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {

                    for (int k = 0; k < 9; k++) {
                        if (k != j && board[i][j] == board[i][k]) {
                            return false;
                        }
                    }

                    for (int k = 0; k < 9; k++) {
                        if (k != i && board[i][j] == board[k][j]) {
                            return false;
                        }
                    }

                    // Check 3x3 box
                    int rowStart = i - (i % 3);
                    int colStart = j - (j % 3);

                    for (int l = rowStart; l < rowStart + 3; l++) {
                        for (int m = colStart; m < colStart + 3; m++) {
                            if ((l != i || m != j) && board[i][j] == board[l][m]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}