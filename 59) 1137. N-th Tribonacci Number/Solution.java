class Solution {

    int[] dp;

    public int tribonaccihelper(int n) {
        if (dp[n] != 0) return dp[n];
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int ans =
            tribonaccihelper(n - 1) +
            tribonaccihelper(n - 2) +
            tribonaccihelper(n - 3);
        dp[n] = ans;
        return ans;
    }

    public int tribonacci(int n) {
        dp = new int[n + 1];
        return tribonaccihelper(n);
    }
}
