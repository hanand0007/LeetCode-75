class Solution {

    public String decodeString(String s) {
        Deque<Integer> counts = new LinkedList<>();
        Deque<String> strings = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                strings.push(ans.toString());
                ans = new StringBuilder();
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(strings.pop());
                int count = counts.pop();
                for (int j = 0; j < count; j++) {
                    sb.append(ans);
                }
                ans = new StringBuilder(sb.toString());
            } else if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                counts.push(Integer.parseInt(sb.toString()));
                i--;
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
