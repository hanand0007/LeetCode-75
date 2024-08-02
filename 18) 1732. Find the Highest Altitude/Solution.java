class Solution {

    // biker is started from zero so, we can check his current Altitude by adding
    // the gain value.
    // and at each step we compare the current altitide with previous heighest
    // altitude.
    public int largestAltitude(int[] gain) {
        int highestAlt = 0, curAlt = 0;
        for (int g : gain) {
            curAlt = curAlt + g;
            highestAlt = Math.max(highestAlt, curAlt);
        }
        return highestAlt;
    }
}
