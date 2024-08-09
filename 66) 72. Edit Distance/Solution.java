class Solution {

    int[][] memArr;

    int minDistanceHelper(String word1, String word2, int i, int j) {
        if (memArr[i][j] != -1) {
            return memArr[i][j];
        }
        if (
            i == word1.length() && j == word2.length()
        ) return 0; // word1 and word2 of same length
        if (
            i == word1.length()
        ) return word2.length() - j; // word1 is small, we need to add chars
        if (
            j == word2.length()
        ) return word1.length() - i; // word2 is big, we need to remove chars

        if (i == word1.length() && j == word2.length()) return 0;

        if (word1.charAt(i) == word2.charAt(j)) {
            // do nothing
            memArr[i][j] = minDistanceHelper(word1, word2, i + 1, j + 1);
            return memArr[i][j];
        } else {
            // insert
            int op1 = 1 + minDistanceHelper(word1, word2, i, j + 1);
            // delete
            int op2 = 1 + minDistanceHelper(word1, word2, i + 1, j);
            // replace
            int op3 = 1 + minDistanceHelper(word1, word2, i + 1, j + 1);
            memArr[i][j] = Math.min(op1, Math.min(op2, op3));
            return memArr[i][j];
        }
    }

    public int minDistance(String word1, String word2) {
        memArr = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : memArr) {
            Arrays.fill(row, -1);
        }
        return minDistanceHelper(word1, word2, 0, 0);
    }
}
