/*

ASCII Values: A : 65, Z : 90, a : 97, z : 122
*/
class PrefixTree {

    TrieNode root;

    class TrieNode {
        //TrieNode is a data structure inside a data structure with default values as null
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        /*
        TC: O(l), where l is length of individual word
            if we consider all the words together it is O(n*l)
        SC: O(n*l)

        Make the curr point to root, get the position of the first alphabet in the word using ascii value,
        if the position is null, create a new trienode and then traverse to insert further characters of the
        word. If in case a trienode already exists then traverse to insert the characters.
        */
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }

            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        /*
        TC: O(l), where length of the word
        SC: O(1)

        Traverse the trienode to find if the word exists, if we find the work, check isEnd, if isEnd is true
        meaning the word exists, else even though we found the word, that word is not present as a complete word
        in dictionary
        */
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        /*
        TC: O(l), where l is the length of the prefix
        SC: O(1)

        diff between search and prefix is we do not need to check isEnd in prefix
        */
        TrieNode curr = root;
        for(char c : prefix.toCharArray())
        {
            if(curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
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