class Solution {

    public int maxArea(int[] height) {
        // taking two pointers for left most and right most element
        int left = 0, right = height.length - 1;
        int ans = Integer.MIN_VALUE;

        while (left < right) {
            int curWater =
                Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, curWater); // checking all posibilities
            // as distance on x-axis is maximum (because pointers are on extreme ends)
            // we need to increase the maximize the height
            if (height[left] < height[right]) { // move left pointer, if height at left is small
                left++;
            } else { // move right pointer, if height at right is small
                right--;
            }
        }
        return ans;
    }
}
