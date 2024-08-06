class Solution {

    boolean[] visited;

    public void dfs(List<List<Integer>> rooms, int n) {
        visited[n] = true;
        for (int i : rooms.get(n)) {
            if (!visited[i]) {
                dfs(rooms, i);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // the rooms can easily be represented as path of graphs
        visited = new boolean[rooms.size()];
        // as we already have key for room zero we can start DFS from 0.
        dfs(rooms, 0);
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
