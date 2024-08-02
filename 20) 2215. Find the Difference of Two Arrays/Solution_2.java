class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // creating set to store occurrence of elements
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        for (int i : set1) {
            // if element is in nums1 but not in nums2
            if (!set2.contains(i)) {
                answer.get(0).add(i);
            }
        }
        for (int i : set2) {
            // if element is in nums2 but not in nums1
            if (!set1.contains(i)) {
                answer.get(1).add(i);
            }
        }

        return answer;
    }
}
