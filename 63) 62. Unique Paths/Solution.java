class Solution {

    public int[][] memArr;

    public int uniquePathsHelper(int m, int n, int i, int j) {
        if (memArr[i][j] != -1) {
            return memArr[i][j];
        }
        if (i >= m || j >= n) return 0;

        if (i == m - 1 && j == n - 1) return 1;

        int r = uniquePathsHelper(m, n, i, j + 1);
        int d = uniquePathsHelper(m, n, i + 1, j);
        memArr[i][j] = r + d;
        return memArr[i][j];
    }

    public int uniquePaths(int m, int n) {
        memArr = new int[m + 1][n + 1];
        for (int[] row : memArr) Arrays.fill(row, -1);
        return uniquePathsHelper(m, n, 0, 0);
    }
}
