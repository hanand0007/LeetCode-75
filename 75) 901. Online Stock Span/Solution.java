class StockSpanner {

    Stack<Pair<Integer, Integer>> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;
        while (!stack.empty() && stack.peek().getKey() <= price) {
            ans = ans + stack.pop().getValue();
        }
        stack.push(new Pair(price, ans));
        return ans;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
