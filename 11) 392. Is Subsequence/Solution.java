class Solution {

    public boolean isSubsequence(String s, String t) {
        int i = 0; // pointer for String s
        int j = 0; // pointer for String t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) { // only increament i, if char at i in string s matches with character at j
                // in string t
                i++;
            }
            j++;
        }

        // if i is equal to s.length, means all character in string s are found in
        // string t
        return i == s.length();
    }
}
