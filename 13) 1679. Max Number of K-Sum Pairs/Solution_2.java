class Solution {

    // Time -> O(N)
    // Space -> O(N)
    public int maxOperations(int[] nums, int k) {
        if (
            nums.length < 2 || k < 1
        ) return 0; // edge case

        int ans = 0;

        // Create a HashMap to store the frequency of each number in the array
        // or we can create frequency Array
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference between the target value k and the current element
            int temp = k - nums[i];

            // Check if the difference is already present in the Map
            if (map.containsKey(temp) && map.get(temp) > 0) { // If yes, increment the ans
                ans++;
                map.put(temp, map.get(temp) - 1); // decreament the frequency
            }
            // If the difference is not present, add the current element to the Map
            else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return ans;
    }
}
