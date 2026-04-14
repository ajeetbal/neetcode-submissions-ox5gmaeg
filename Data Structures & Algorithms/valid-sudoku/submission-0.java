class Solution {
    public boolean isValidSudoku(char[][] board) {
 
		int n = 9;
		HashSet<Character>[] rowset = new HashSet[n];
		HashSet<Character>[] colset = new HashSet[n];
		HashSet<Character>[] boxset = new HashSet[n];

		for (int i = 0; i < n; i++) {
			rowset[i] = new HashSet<>();
			colset[i] = new HashSet<>();
			boxset[i] = new HashSet<>();

		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				Character cell = board[row][col];
				if (cell == '.') {
					continue;
				}

				if (rowset[row].contains(cell)) {
					return false;
				}
				rowset[row].add(cell);

				if (colset[col].contains(cell)) {
					return false;
				}
				colset[col].add(cell);

				int boxIndex = 3 * (row / 3) + (col / 3);

				if (boxset[boxIndex].contains(cell)) {
					return false;
				}
				boxset[boxIndex].add(cell);
			}
		}

		return true;       
        
    }
}
