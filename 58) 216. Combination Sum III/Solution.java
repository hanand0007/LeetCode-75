class Solution {

    List<List<Integer>> ans;

    public void combinationSum3Helper(int i, int k, int n, List<Integer> curr) {
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (i > 9) return;
        if (n < 0 || k < 0) return;

        curr.add(i);
        combinationSum3Helper(i + 1, k - 1, n - i, curr);
        curr.remove(curr.size() - 1);
        combinationSum3Helper(i + 1, k, n, curr);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        combinationSum3Helper(1, k, n, new ArrayList<>());
        return ans;
    }
}
