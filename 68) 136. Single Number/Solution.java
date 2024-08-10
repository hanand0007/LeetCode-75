class Solution {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans = ans ^ n; //XOR all number same number will cancel out
        }
        return ans;
    }
}
