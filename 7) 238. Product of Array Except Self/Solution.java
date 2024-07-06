class Solution {

    public int[] productExceptSelf(int[] nums) {
        // keeping single product array will not work,
        // zero will make the product as zero.
        int[] proArrL = new int[nums.length]; // left product array
        int[] proArrR = new int[nums.length]; // right product array
        int leftPro = 1;
        int rightPro = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            leftPro *= nums[i];
            rightPro *= nums[j];
            proArrL[i] = leftPro;
            proArrR[j] = rightPro;
        }
        // length >= 2, so updating first and last element first.
        nums[0] = proArrR[1];
        nums[nums.length - 1] = proArrL[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = proArrL[i - 1] * proArrR[i + 1];
        }
        return nums;
    }
}
