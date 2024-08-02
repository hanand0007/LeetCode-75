class Solution {

    // Time -> O(N)
    public int longestSubarray(int[] nums) {
        int numZeros = 0, ans = 0;
        int l = 0, r = 0;
        while (r < nums.length) { // for each r checking possible ans
            if (nums[r] == 0) {
                numZeros++;
            }
            // if, for any case, num of zeros becomes greater than 1 that means l needs to
            // be shifted
            while (numZeros > 1) {
                if (nums[l] == 0) {
                    numZeros--;
                }
                l++;
            }
            ans = Math.max(ans, r - l); // as number zero is removed, that means ans will r - l only
            r++;
        }
        return ans;
    }
}
