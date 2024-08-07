class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int n : nums) {
            if (q.size() < k) q.add(n);
            else if (n > q.peek()) {
                q.remove();
                q.add(n);
            }
        }
        return q.peek();
    }
}
