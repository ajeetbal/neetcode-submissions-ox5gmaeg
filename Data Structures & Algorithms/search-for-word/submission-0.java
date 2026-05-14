class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        int index = 0;
        // Try starting the word from every single cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, index)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        // 1. Success Base Case: We found all characters
        if (index == word.length()) {
            return true;
        }

        // 2. Failure Base Case: Out of bounds or character mismatch
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
            || board[r][c] != word.charAt(index)) {
            return false;
        }

        // 3. Choose: Mark the current cell as visited
        char tmp = board[r][c];
        board[r][c] = '#';

        // 4. Explore: Try all 4 directions
        boolean found = backtrack(board, word, r + 1, c, index + 1) || // Down
            backtrack(board, word, r, c + 1, index + 1) || // Right
            backtrack(board, word, r - 1, c, index + 1) || // UP
            backtrack(board, word, r, c - 1, index + 1); // Left

        // 5. Un-choose: Restore the cell (Backtrack)
        board[r][c] = tmp;

        return found;
    }
}
