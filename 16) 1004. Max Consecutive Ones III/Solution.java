class Solution {

    // Time -> O(N)
    // As the number of zeros can be replaced with 1 for upto k times
    // therefore, keeping track of number of zeros
    public int longestOnes(int[] nums, int k) {
        int numZeros = 0, ans = 0;
        int l = 0, r = 0;
        while (r < nums.length) { // for each r checking possible ans
            if (nums[r] == 0) {
                numZeros++;
            }
            // if, for any case, num of zeros becomes greater than k that means l needs to
            // be shifted
            while (numZeros > k) {
                if (nums[l] == 0) {
                    numZeros--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
