class Solution {

    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : senate.toCharArray()) queue.add(c);

        char c = 'R';
        while (!queue.isEmpty()) {
            c = queue.poll();
            queue.add(c);

            if (c == 'R' && !queue.remove('D')) return "Radiant";
            if (c == 'D' && !queue.remove('R')) return "Dire";
        }
        return null;
    }
}
