class Solution {

    public String reverseWords(String s) {
        boolean isTraversingWord = false; // to keep track if traversing a word or white spaces
        StringBuilder ans = new StringBuilder();
        StringBuilder currWord = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                isTraversingWord = false;
                if (currWord.length() > 0) {
                    ans.append(currWord.reverse()); // adding current word
                    ans.append(' ');
                    currWord = new StringBuilder();
                }
            } else {
                isTraversingWord = true;
            }
            if (isTraversingWord) { // updating current word
                currWord.append(s.charAt(i));
            }
        }
        if (currWord.length() > 0) {
            ans.append(currWord.reverse()); // add last word
        } else {
            ans.deleteCharAt(ans.length() - 1); // removes last white space
        }
        return ans.toString();
    }
}
