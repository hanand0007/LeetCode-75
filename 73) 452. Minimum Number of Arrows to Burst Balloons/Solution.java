class Solution {

    public int findMinArrowShots(int[][] points) {
        int ans = 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];
            if (start > prevEnd) {
                prevEnd = end;
            } else {
                ans += 1;
                prevEnd = Math.min(end, prevEnd);
            }
        }
        return points.length - ans;
    }
}
