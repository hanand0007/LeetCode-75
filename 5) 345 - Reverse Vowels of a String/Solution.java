class Solution {
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        else
            return false;
    }

    static String swap(int i, int j, String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (isVowel(s.charAt(start)) && isVowel(s.charAt(end))) {
                s = swap(start, end, s);
                start++;
                end--;
            } else if (isVowel(s.charAt(start)) && !isVowel(s.charAt(end))) {
                end--;
            } else if (!isVowel(s.charAt(start)) && isVowel(s.charAt(end))) {
                start++;
            } else {
                start++;
                end--;
            }
        }
        return s;
    }
}