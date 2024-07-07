class Solution {

    // Time -> O(nlogn)
    // Space -> O(1)
    public int maxOperations(int[] nums, int k) {
        // sort the array
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        // use two pointers to get the possible pairs
        while (left < right) {
            int curSum = nums[left] + nums[right];
            if (curSum == k) {
                ans++;
                left++;
                right--;
            } else if (curSum < k) {
                left++;
            } else { // curSum > k
                right--;
            }
        }
        return ans;
    }
}
