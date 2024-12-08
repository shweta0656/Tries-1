/*
TC: O(N*l + M*l)
-To put all the words from the Dictionary to form a Trie: O(N*l), N is the total number of words and l is the
length of each word
-Split the sentence: O(M*l), M is the words in the sentence, l is the length of each word
-Going over each word and searching in the Tire: O(M*l), M is the words in the sentence, l is the length of
each word

=> O(N*l + M*l + M*l) = O(N*l + 2(M*l)) = O(N*l + M*l) whichever is larger out of N*l or M*l will have the
effective time complexity

SC: O(N*l + M*l)

The Trie may store up to O(N*l) nodes, and each node stores an array with 26 pointers, so the Trie requires
O(N*l*26) space. 26 is a constant factor, so we can simplify this to O(N*l). The data structure that stores
the words in the sentence uses O(M*l) space.
*/
import java.util.List;

class ReplaceWords
{
    TrieNode root;
    class TrieNode
    {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word) {
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

    public String replaceWords(List<String> dictionary, String sentence)
    {
        StringBuilder result = new StringBuilder();
        this.root = new TrieNode();

        //creating trie out of dictionary
        for(String word : dictionary) {
            insert(word);
        }

        //splitting the sentence based on space and storing in a string array
        String[] splitArr = sentence.split(" ");
        for(int i=0; i<splitArr.length; i++)
        {
            if(i>0) result.append(" ");
            result.append(getShortestVersion(splitArr[i]));
        }

        return result.toString();
    }

    private String getShortestVersion(String word)
    {
        StringBuilder result = new StringBuilder();
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c-'a'] == null || curr.isEnd) {
                break;
            }

            curr = curr.children[c-'a'];
            result.append(c);
        }

        if(curr.isEnd) {
            return result.toString();
        }

        return word;
    }
}