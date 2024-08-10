class Solution {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int t = i;
            while (t != 0) {
                if (t % 2 == 1) {
                    ans[i]++;
                }
                t /= 2;
            }
        }
        return ans;
    }
}
