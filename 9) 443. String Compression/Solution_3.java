class Solution {

    // Two Pointer
    // Time -> O(N)
    // Space -> O(1)
    public int compress(char[] chars) {
        int left = 0;
        int right = 0;
        int idx = 0;
        while (right < chars.length) {
            char c = chars[right];

            // inceament right until new character
            while (right < chars.length && c == chars[right]) {
                right++;
            }

            int count = right - left;
            chars[idx++] = c;

            if (count > 1) { // only add count if greater than 1
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[idx++] = digit;
                }
            }

            left = right;
        }
        return idx;
    }
}
