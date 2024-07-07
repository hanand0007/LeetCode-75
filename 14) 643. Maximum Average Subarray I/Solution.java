class Solution {

    public double findMaxAverage(int[] nums, int k) {
        // to store the sum of window of size k
        int sum = 0;

        // getting sum of first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double ans = (double) sum / k;

        int left = 0, right = k;

        // checking sum for each window of size k
        while (right < nums.length) {
            sum -= nums[left];
            sum += nums[right];
            ans = Math.max(ans, (double) sum / k);
            left++;
            right++;
        }

        return ans;
    }
}
