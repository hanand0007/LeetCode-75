class Solution {

    class UnionFind {

        int[] par;
        int[] size;
        int numComponents;

        int getNumComponents() {
            return numComponents;
        }

        UnionFind(int n) {
            par = new int[n + 1];
            size = new int[n + 1];
            numComponents = n;
            for (int i = 1; i <= n; ++i) {
                par[i] = i;
                size[i] = 1;
            }
        }

        int root(int i) { // find the root of the tree in which node i is present
            if (par[i] == i) return i;
            return par[i] = root(par[i]); // path compression
        }

        boolean find(int i, int j) {
            return root(i) == root(j);
        }

        boolean union(int n1, int n2) { // true if they were actually unioned, otherwise false
            int u = root(n1);
            int v = root(n2);

            if (u == v) return false;

            if (size[u] < size[v]) {
                int temp = u;
                u = v;
                v = temp;
            } // size[u] should be larger than size[v]

            par[v] = u; // u is the root of resultant tree
            size[u] += size[v];
            numComponents -= 1;
            return true;
        }
    } // By default, 1-based indexing (1 to n)

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind dsu = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j); // adding edges in the DSU
                }
            }
        }
        return dsu.getNumComponents();
    }
}
