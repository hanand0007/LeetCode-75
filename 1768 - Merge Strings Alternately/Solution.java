class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0, k = 0;
        StringBuilder ans = new StringBuilder();
        while (i < word1.length() && j < word2.length()) {
            if (k % 2 == 0) { //Adding word1's char to even places
                ans.append(word1.charAt(i));
                i++;
            } else { //Adding word2's char to odd places
                ans.append(word2.charAt(j));
                j++;
            }
            k++;
        }
        if (i == word1.length()) { //adding rest of word2 (word1 is complete)
            ans.append(word2.substring(j));
        } else { //adding rest of word1 (word2 is complete)
            ans.append(word1.substring(i));
        }
        return ans.toString();
    }
}