class Solution {
    public boolean isValid(char[][] board, int row, int col, char num) {
        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }
        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }
        // Check 3x3 matrix
        int sRow = row / 3 * 3;
        int sCol = col / 3 * 3;
        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    public void solve(char[][] board, int row, int col, char[][] grid, boolean[] found) {
        if (found[0]) return; 

        if (row == 9) {
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = board[i][j];
                }
            }
            found[0] = true;
            return;
        }

        if (board[row][col] != '.') {
            if (col != 8) solve(board, row, col + 1, grid, found);
            else solve(board, row + 1, 0, grid, found);
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValid(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (col != 8) solve(board, row, col + 1, grid, found);
                    else solve(board, row + 1, 0, grid, found);
                    board[row][col] = '.'; 
                }
            }
        }
    } 

    public void solveSudoku(char[][] board) {
        char[][] grid = new char[9][9];
        boolean[] found = new boolean[1]; 
        solve(board, 0, 0, grid, found);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = grid[i][j];
            }
        }
    }
}
