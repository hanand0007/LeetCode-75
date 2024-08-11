class Node {

    boolean isWord = false;
    Node[] childs; // or Map<Charcter,Node>() can be used

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
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.childs[index] == null) {
                curr.childs[index] = new Node();
            }
            curr = curr.childs[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.childs[index] != null) {
                curr = curr.childs[index];
            } else {
                return false;
            }
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.childs[index] != null) {
                curr = curr.childs[index];
            } else {
                return false;
            }
        }
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
