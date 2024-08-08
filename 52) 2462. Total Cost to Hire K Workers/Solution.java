class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long ans = 0;
        int i;
        for (i = 0; i < candidates; i++) {
            left.add(costs[i]);
        }
        int n = costs.length;
        int j;
        for (j = n - 1; j >= n - candidates && j >= i; j--) {
            right.add(costs[j]);
        }

        for (int a = 0; a < k; a++) {
            if (left.size() == 0) {
                ans += right.poll();
                if (j >= i) right.add(costs[j--]);
                continue;
            }
            if (right.size() == 0) {
                ans += left.poll();
                if (i <= j) left.add(costs[i++]);
                continue;
            }

            if (left.peek() <= right.peek()) {
                ans += left.poll();
                if (i <= j) left.add(costs[i++]);
            } else {
                ans += right.poll();
                if (j >= i) right.add(costs[j--]);
            }
        }
        return ans;
    }
}
