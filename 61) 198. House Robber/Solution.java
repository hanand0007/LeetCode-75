class Solution {

    public int[][] memArray = new int[2][101];

    public int rob(int[] nums) {
        for (int[] row : memArray) Arrays.fill(row, -1);
        return rob(nums, false, 0);
    }

    public int rob(int[] nums, boolean isPrevTraverse, int i) {
        if (i == nums.length) {
            return 0;
        }
        if (
            memArray[isPrevTraverse ? 1 : 0][i] != -1
        ) return memArray[isPrevTraverse ? 1 : 0][i];
        int m1, m2, m3;
        m1 = m2 = m3 = Integer.MIN_VALUE;
        if (isPrevTraverse) {
            m1 = rob(nums, false, i + 1);
        } else {
            m2 = nums[i] + rob(nums, true, i + 1);
            m3 = rob(nums, false, i + 1);
        }
        int result = Math.max(m1, Math.max(m2, m3));
        memArray[isPrevTraverse ? 1 : 0][i] = result;
        return result;
    }
}
