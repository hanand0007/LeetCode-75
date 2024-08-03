class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        // creating map to store occurrences/frequency of each unique element
        Map<Integer, Integer> occMap = new HashMap<>();
        for (int a : arr) {
            occMap.put(a, occMap.getOrDefault(a, 0) + 1);
        }

        // creating a set to check value of occurrences is unique
        // as set does not allow repeated value we can add the above map into a set
        Set<Integer> set = new HashSet<>();
        for (int v : occMap.values()) {
            set.add(v);
        }

        // if size of Map and Set is same that means we have unique elements in the
        // given Map
        return set.size() == occMap.size();
    }
}
