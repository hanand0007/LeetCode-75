class Solution {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            // evaluating column for each i
            for (int j = 0; j < n; j++) {
                col[j] = grid[j][i];
            }
            // comparing the column with all rows
            for (int k = 0; k < n; k++) {
                // if current column matches with any row we will increament the counter
                if (Arrays.equals(grid[k], col)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
