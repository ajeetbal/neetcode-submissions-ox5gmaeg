class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0 , r = (rows * cols) - 1;
       
        while( l <= r){
            int mid = l + (r-l)/2;
            int row = mid/cols;
            int col = mid%cols;

            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col] > target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }

        }
    return false;
    }
}
