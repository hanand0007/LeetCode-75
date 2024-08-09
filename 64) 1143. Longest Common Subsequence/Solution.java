class Solution {

    int[][] memArr;

    public int longestCommonSubsequenceH(
        String text1,
        String text2,
        int i,
        int j
    ) {
        if (i == text1.length() || j == text2.length()) return 0;
        if (memArr[i][j] != -1) {
            return memArr[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + longestCommonSubsequenceH(text1, text2, i + 1, j + 1);
        } else {
            int op1, op2;
            op1 = longestCommonSubsequenceH(text1, text2, i + 1, j);
            op2 = longestCommonSubsequenceH(text1, text2, i, j + 1);
            memArr[i][j] = Math.max(op1, op2);
            return memArr[i][j];
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        memArr = new int[1001][1001];
        for (int[] r : memArr) {
            Arrays.fill(r, -1);
        }
        return longestCommonSubsequenceH(text1, text2, 0, 0);
    }
}
