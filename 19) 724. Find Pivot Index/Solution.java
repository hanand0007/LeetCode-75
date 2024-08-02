class Solution {

    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;

        // adding all elements in array to create rightSum
        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i]; // removing current element
            if (rightSum == leftSum) { // return i value if at any index leftSum becomes equal to righSum
                return i;
            }
            leftSum += nums[i]; // adding current element to left sum
        }
        return -1;
    }
}
