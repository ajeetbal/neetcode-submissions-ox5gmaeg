class TrieNode {
    TrieNode[] children;
    boolean isLeaf;

    TrieNode() {
        children = new TrieNode[26];
        isLeaf = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }

        curr.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return searchRecursive(word, 0, curr);
    }

    private boolean searchRecursive(String word, int index, TrieNode curr) {
        if (index == word.length()) {
            return curr.isLeaf;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : curr.children) {
                if (child != null && searchRecursive(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if (curr.children[c - 'a'] != null) {
                return searchRecursive(word, index + 1, curr.children[c - 'a']);
            }
            return false;
        }
    }
}
