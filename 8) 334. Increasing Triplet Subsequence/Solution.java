class Solution {

    public boolean increasingTriplet(int[] nums) {
        if (
            nums.length < 3
        ) return false; // base case, if length is less than 3, triplet is not possible

        // as index are not sequential
        // we need to check for all possibility
        // for a given index
        // if in the left Array a smaller value is found and in right Array a greater
        // value is found
        // then tripplet is possible
        int[] leftMinArray = new int[nums.length]; // left minimum Array
        int[] rightMaxArray = new int[nums.length]; // right maximum Array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // filling the Arrays
        for (int i = 0, j = nums.length - 1; j >= 0; i++, j--) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[j] > max) {
                max = nums[j];
            }
            leftMinArray[i] = min;
            rightMaxArray[j] = max;
        }

        // simply comparing with left minimum and right maximum array
        for (int i = 1; i < nums.length - 1; i++) {
            if (
                nums[i] > leftMinArray[i - 1] && nums[i] < rightMaxArray[i + 1]
            ) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }
}
