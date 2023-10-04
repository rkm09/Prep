package datastructures.trie;

// Prefix Tree
public class Trie {

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

//    time: O(m), where m is the key length. n each iteration of the algorithm, we either examine or create a node in the trie till we reach the end of the key. This takes only m operations.
//    space: O(m), In the worst case newly inserted key doesn't share a prefix with the  keys already inserted in the trie. We have to add m nodes.
//   inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0 ; i < word.length() ; i++) {
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

//   search a prefix or whole key in trie and returns the node where the search ends.
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i = 0 ; i < word.length() ; i++) {
            char currChar = word.charAt(i);
            if(node.containsKey(currChar)) {
                node = node.get(currChar);
            } else return null;
        }
        return node;
    }

//    time: O(m), In each step of the algorithm we search for the next key character. In the worst case the algorithm performs m operations.
//    space: O(1)
//    returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

//    time: O(m), space: O(1)
//    returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

/*
Search for a key prefix in a trie:
The approach is very similar to the one we used for searching a key in a trie. We traverse the trie from the root, till there are no characters left in key prefix or it is impossible to continue the path in the trie with the current key character. The only difference with the search mentioned above for a key algorithm is that when we come to an end of the key prefix, we always return true. We don't need to consider the isEnd mark of the current trie node, because we are searching for a prefix of the key, not for the whole key.
Applications of Trie:
Autocomplete, Spell Checker, IP routing(longest prefix matching), T9 predictive text, Solving word games
 */