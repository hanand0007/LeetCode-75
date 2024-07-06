class Solution {

    // Time -> O(N)
    // Space -> O(N) (for StringBuilder)
    public int compress(char[] chars) {
        if (chars.length == 1) { // edge case, do nothing and return 1
            return 1;
        }
        char curChar = chars[0];
        int count = 1;
        StringBuilder ans = new StringBuilder();
        // using StringBuilder to store compressed String (Extra Space)
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == curChar) { // matching character, increment count
                count++;
            } else {
                ans.append(curChar);
                if (count > 1) ans.append(Integer.toString(count)); // only add count if greater than 1

                //Resetting variables for new character
                curChar = chars[i];
                count = 1;
            }
        }
        if (count > 0) { // adding last character
            ans.append(curChar);
            if (count > 1) ans.append(Integer.toString(count));
        }
        // moving ans string to chars Array
        for (int j = 0; j < ans.length(); j++) {
            chars[j] = ans.charAt(j);
        }
        return ans.length();
    }
}
