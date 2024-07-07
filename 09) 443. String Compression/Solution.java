class Solution {

    // Time -> O(N)
    // Space -> O(1)
    public int compress(char[] chars) {
        if (chars.length == 1) { // edge case, do nothing and return 1
            return 1;
        }
        char curChar = chars[0];
        int count = 1;
        int ansIdx = 0; // to keep the track of ans Index
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == curChar) {
                count++;
            } else {
                String s = getStringForChar(curChar, count);
                for (int j = 0; j < s.length(); j++) {
                    chars[ansIdx++] = s.charAt(j);
                }

                // Resetting variables for new character
                curChar = chars[i];
                count = 1;
            }
        }
        if (count > 0) {
            String s = getStringForChar(curChar, count);
            for (int j = 0; j < s.length(); j++) {
                chars[ansIdx++] = s.charAt(j);
            }
        }
        return ansIdx;
    }

    public String getStringForChar(char c, int count) {
        StringBuilder s = new StringBuilder();
        s.append(c);
        if (count > 1) {
            s.append(Integer.toString(count));
        }
        return s.toString();
    }
}
