class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int curSp = spells[i];
            int start = 0;
            int end = potions.length - 1;
            int idx = -1;
            while (start <= end) {
                int middle = start + (end - start) / 2;
                long valAtMiddle = (long) potions[middle] * curSp;
                if (valAtMiddle >= success) {
                    idx = middle;
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            ans[i] = idx == -1 ? 0 : potions.length - idx;
        }
        return ans;
    }
}
