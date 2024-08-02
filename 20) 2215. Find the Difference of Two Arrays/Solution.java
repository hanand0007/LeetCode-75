class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // creating maps to store occurrence of elements
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int n : nums1) {
            map1.put(n, 1);
        }
        for (int n : nums2) {
            map2.put(n, 1);
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        for (int i = -1000; i <= 1000; i++) { // range is -1000 to 1000
            // if element is in nums1 but not in nums2
            if (map1.get(i) != null && map2.get(i) == null) {
                answer.get(0).add(i);
            } else if (map1.get(i) == null && map2.get(i) != null) {
                answer.get(1).add(i);
            }
        }
        return answer;
    }
}
