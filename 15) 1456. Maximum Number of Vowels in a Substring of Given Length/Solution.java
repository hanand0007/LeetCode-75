class Solution {

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        int vowelCount = 0;

        // getting vowel's count of first string of size k
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) vowelCount++;
        }

        int ans = vowelCount;

        int left = 0, right = k;

        // checking vowel's count for each window of size k
        while (right < s.length()) {
            // decrement only if char at left is vowel;
            if (isVowel(s.charAt(left))) {
                vowelCount--;
            }
            // increment only if char at right is vowel;
            if (isVowel(s.charAt(right))) {
                vowelCount++;
            }
            ans = Math.max(ans, vowelCount);
            left++;
            right++;
        }

        return ans;
    }
}
