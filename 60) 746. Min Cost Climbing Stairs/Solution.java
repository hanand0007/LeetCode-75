class Solution {

    int[] dp;

    public int minCostClimbingStairsHelper(int i, int n, int[] cost) {
        if (dp[i] != 0) return dp[i];
        if (i == n - 1 || i == n - 2) return cost[i];
        int oneUp = cost[i] + minCostClimbingStairsHelper(i + 1, n, cost);
        int twoUp = cost[i] + minCostClimbingStairsHelper(i + 2, n, cost);
        int ans = Math.min(oneUp, twoUp);
        dp[i] = ans;
        return ans;
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        int idxO = minCostClimbingStairsHelper(0, n, cost);
        int idx1 = minCostClimbingStairsHelper(1, n, cost);
        int ans = Math.min(idxO, idx1);
        return ans;
    }
}
