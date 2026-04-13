from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or not word:
            return False
        
        rows = len(board)
        cols = len(board[0])
        
        def search(r, c, index):
            if index == len(word):
                return True
            
            if (r < 0 or r >= rows or 
                c < 0 or c >= cols or 
                board[r][c] != word[index] or 
                board[r][c] == ""):
                return False
            
            temp = board[r][c]
            board[r][c] = ""
            
            found = (search(r + 1, c, index + 1) or 
                     search(r - 1, c, index + 1) or 
                     search(r, c + 1, index + 1) or 
                     search(r, c - 1, index + 1))
            
            board[r][c] = temp
            return found

        for i in range(rows):
            for j in range(cols):
                if board[i][j] == word[0]:
                    if search(i, j, 0):
                        return True
                        
        return False