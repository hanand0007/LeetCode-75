class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); // Monotonic Decreasing Stack
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (
                !stack.empty() && temperatures[stack.peek()] < temperatures[i]
            ) {
                ans[stack.peek()] = (i - stack.pop());
            }
            stack.add(i);
        }
        return ans;
    }
}
