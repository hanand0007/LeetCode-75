class Solution {
    public String gcdOfStringsHelper(String str1, String str2) {
        if (str1.length() > str2.length()) { // str1 is longer than str2, keeping small length string as first arg
            return gcdOfStringsHelper(str2, str1);
        } else if (!str2.startsWith(str1)) { // Non-common character found, return empty string
            return "";
        } else if (str1.isEmpty()) { // str1 is empty, means str2 is the gcd of both strings
            return str2;
        } else { // str2 starts with str1
            return gcdOfStringsHelper(str2.substring(str1.length()), str1);
        }
    }

    public String gcdOfStrings(String str1, String str2) {
        return gcdOfStringsHelper(str1, str2);
    }
}