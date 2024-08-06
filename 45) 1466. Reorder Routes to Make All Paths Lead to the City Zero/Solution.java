class Solution {

    int count = 0;

    public void minReorderHelper(
        Map<Integer, Map<Integer, Integer>> map,
        int curr,
        int prev
    ) {
        if (map.get(curr).size() == 1 && curr != 0) return;
        for (int key : map.get(curr).keySet()) {
            if (key == prev) continue;
            if (map.get(curr).get(key) == 1) {
                count++;
            }
            minReorderHelper(map, key, curr);
        }
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, Map<Integer, Integer>> maps = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            int e = connections[i][0];
            int f = connections[i][1];
            Map<Integer, Integer> map1 = maps.getOrDefault(e, new HashMap<>());
            map1.put(f, 1);
            maps.put(e, map1);
            Map<Integer, Integer> map2 = maps.getOrDefault(f, new HashMap<>());
            map2.put(e, -1);
            maps.put(f, map2);
        }

        minReorderHelper(maps, 0, -1);
        return count;
    }
}
