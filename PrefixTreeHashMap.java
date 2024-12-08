/*
TC: O(n*l)
Sc: O(n*l)

If all the ascii values are included, and we do not know what should be the range of our character array and
how we can access it based on its index, in such cases we can use hashmap
*/
import java.util.HashMap;

class PrefixTreeHashMap {

    TrieNode root;

    class TrieNode {

        HashMap<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    public PrefixTreeHashMap() {
        this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }

            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;
        for(char c : prefix.toCharArray())
        {
            if(!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
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