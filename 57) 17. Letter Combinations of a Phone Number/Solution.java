class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> toRet = new ArrayList<>();
        char[][] arr = {
            {}, //0
            {}, //1
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }, //9
        };
        if (digits.length() == 0) {
            return toRet;
        }
        List<String> temp = new ArrayList<>();
        for (char ch : arr[Integer.parseInt(digits.substring(0, 1))]) {
            temp.add(String.valueOf(ch));
        }
        for (int k = 1; k < digits.length(); k++) {
            String[] temp1 = new String[temp.size()];

            int i = 0;
            for (String c : temp) temp1[i++] = c;

            temp = new ArrayList<>();
            for (String c : temp1) {
                char[] char2 =
                    arr[Integer.parseInt(digits.substring(k, k + 1))];
                for (char value : char2) {
                    temp.add(String.valueOf(c) + value);
                }
            }
        }
        return temp;
    }
}
