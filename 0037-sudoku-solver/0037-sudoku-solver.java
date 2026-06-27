class Solution {

    static boolean isSafe(char[][] board, int row, int col, char dig) {
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == dig) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == dig) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == dig) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char dig = '1'; dig <= '9'; dig++) {
                        if (isSafe(board, i, j, dig)) {
                            board[i][j] = dig;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}