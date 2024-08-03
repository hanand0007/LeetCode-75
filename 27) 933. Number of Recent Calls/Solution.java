class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        // remove all number from queue which are smaller then start of range i.e (t - 3000)
        while (queue.peek() != null && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
