class Solution {

    public String removeStars(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') { // for each * we need to remove previous character
                stack.pop();
            } else { // if the character is not * simply add to stack
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        // reversing the string
        return sb.reverse().toString();
    }
}
