class Solution {

    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double compute(
        String s,
        String l,
        Set<String> seen,
        double proSoFar
    ) {
        if (!graph.containsKey(s) || !graph.containsKey(l)) { // if s or l does not belong to graph
            return -1;
        }
        if (s.equals(l)) {
            return proSoFar;
        }
        seen.add(s);
        Map<String, Double> mapOfS = graph.get(s);
        for (String key : mapOfS.keySet()) {
            if (seen.contains(key)) {
                continue;
            }
            double val = mapOfS.get(key);
            double compute = compute(key, l, seen, proSoFar * val);
            if (compute != -1) {
                return compute;
            }
        }
        return -1;
    }

    public double[] calcEquation(
        List<List<String>> equations,
        double[] values,
        List<List<String>> queries
    ) {
        int ptr = 0;
        for (List<String> e : equations) {
            String varA = e.get(0);
            String varB = e.get(1);
            double weight = values[ptr++];
            graph.putIfAbsent(varA, new HashMap<>());
            graph.putIfAbsent(varB, new HashMap<>());
            graph.get(varA).put(varB, weight);
            graph.get(varB).put(varA, 1 / weight);
        }
        ptr = 0;
        double[] ans = new double[queries.size()];
        for (List<String> q : queries) {
            ans[ptr++] = compute(q.get(0), q.get(1), new HashSet<>(), 1);
        }
        return ans;
    }
}
