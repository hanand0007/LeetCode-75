class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1) return timeTakenPerPile(piles[0], h);
        long e = piles[0];
        for (int p : piles) {
            if (p > e) e = p;
        }
        long s = 1;
        long ans = -1;
        while (s <= e) {
            long m = s + (e - s) / 2;
            long timetakenatmid = totalTimeTaken(piles, m);
            if (timetakenatmid <= h) {
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return (int) ans;
    }

    public static long totalTimeTaken(int[] piles, long speed) {
        long ans = 0;
        for (int a : piles) {
            ans += timeTakenPerPile(a, (int) speed);
        }
        return ans;
    }

    public static int timeTakenPerPile(int bananas, int speed) {
        if (bananas % speed == 0) {
            return bananas / speed;
        } else {
            return bananas / speed + 1;
        }
    }
}
