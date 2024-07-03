class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // getting maximum number of candy a kid can have.
        int maxCandy = Integer.MIN_VALUE;
        for (int i : candies) {
            if (i > maxCandy)
                maxCandy = i;
        }

        // comparing each kid's candy plus extraCandies with max Candy
        // and updating the ans list
        List<Boolean> ans = new ArrayList<>();
        for (int i : candies) {
            ans.add(i + extraCandies >= maxCandy);
        }

        return ans;
    }
}