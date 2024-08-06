class Solution {

    boolean[] visited; // array to keep track of node visited

    public void dfs(int[][] isConnected, int node) {
        visited[node] = true; // mark visited
        int n = isConnected.length;
        for (int i = 0; i < n; ++i) { // traverse the adjacent nodes
            if (isConnected[node][i] == 1 && !visited[i]) { // call dfs if adj node (has a edge) and is not visited
                dfs(isConnected, i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new boolean[n];
        int count = 0;

        // if a node is passed to dfs
        // it will traverse all the connected nodes for that node i.e. component
        for (int i = 0; i < n; i++) {
            // if a node is not visited, it means it was not traversed by previous calls
            // Hence, call dfs and increment count value
            if (!visited[i]) {
                count++;
                dfs(isConnected, i);
            }
        }
        return count;
    }
}
