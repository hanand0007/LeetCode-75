class SmallestInfiniteSet {

    PriorityQueue<Integer> q;

    public SmallestInfiniteSet() {
        q = new PriorityQueue<>();
        for (int i = 1; i < 2000; i++) {
            q.add(i);
        }
    }

    public int popSmallest() {
        int res = -1;
        if (q.size() > 0) {
            res = q.poll();
        }
        return res;
    }

    public void addBack(int num) {
        if (q.contains(num)) return;
        q.add(num);
    }
}
/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
