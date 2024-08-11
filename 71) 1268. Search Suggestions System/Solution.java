class Node {

    boolean isWord = false;
    Node[] childs;

    Node() {
        childs = new Node[26];
    }
}

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.childs[index] == null) {
                curr.childs[index] = new Node();
            }
            curr = curr.childs[index];
        }
        curr.isWord = true;
    }

    private void DFS(Node curNode, StringBuilder curString, List<String> ans) {
        if (ans.size() == 3) return;
        if (curNode.isWord) ans.add(curString.toString());

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (curNode.childs[ch - 'a'] == null) continue;
            curString.append(ch);
            DFS(curNode.childs[ch - 'a'], curString, ans);
            curString.deleteCharAt(curString.length() - 1);
        }
    }

    List<String> getTop3Words(String w) {
        Node curr = root;
        for (char ch : w.toCharArray()) {
            int index = ch - 'a';
            if (curr.childs[index] == null) return new ArrayList<>();
            curr = curr.childs[index];
        }

        List<String> ans = new ArrayList<>();
        StringBuilder curString = new StringBuilder(w);
        DFS(curr, curString, ans);
        return ans;
    }
}

class Solution {

    public List<List<String>> suggestedProducts(
        String[] products,
        String searchWord
    ) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            ans.add(trie.getTop3Words(searchWord.substring(0, i)));
        }
        return ans;
    }
}
