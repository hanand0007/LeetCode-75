class Solution {

    public boolean closeStrings(String word1, String word2) {
        // Allowed operations are
        // Operation 1: Swap any two existing characters.
        // Operation 2: Transform every occurrence of one existing character
        // into another existing character.
        // In simple words, if occurrence of all characters in word1 maps to
        // occurrence of all character in word2 and
        // they have same characters (not necessarily with same occurrence).
        // then they will be close Strings.

        if (
            word1.length() != word2.length()
        ) return false; // base condition, if words length is not same

        int n = word1.length();

        // To strore word1's characters occurrences
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map1.put(
                word1.charAt(i),
                map1.getOrDefault(word1.charAt(i), 0) + 1
            );
        }

        // To strore word2's characters occurrences
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map2.put(
                word2.charAt(i),
                map2.getOrDefault(word2.charAt(i), 0) + 1
            );
        }

        // Making sure they have the same keySet, i.e contains same characters
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        // Using List instead of Set to allow repeated values
        // Add map1 values to list
        List<Integer> list = new ArrayList<>();
        for (int v : map1.values()) {
            list.add(v);
        }
        // For each map2 value remove same value in map1
        for (int v : map2.values()) {
            list.remove(Integer.valueOf(v));
        }
        // If all values are removed from the list, it means string are close string
        return list.size() == 0;
    }
}
