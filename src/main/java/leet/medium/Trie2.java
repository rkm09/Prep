package leet.medium;

public class Trie2 {

    TrieNode2 root;
    public Trie2() {
        root = new TrieNode2();
    }

    public void insert(String word) {
        TrieNode2 node = root;
        for(char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            if(node.links[charIndex] == null) {
                node.links[charIndex] = new TrieNode2();
            }
            node = node.links[charIndex];
            node.wordsStartingHere++;
        }
        node.wordsEndingHere++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode2 node = root;
        for(char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            if(node.links[charIndex] == null) return 0;
            node = node.links[charIndex];
        }
        return node.wordsEndingHere;
    }

    public int countWordsStartingWith(String word) {
        TrieNode2 node = root;
        for(char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            if(node.links[charIndex] == null) return 0;
            node = node.links[charIndex];
        }
        return node.wordsStartingHere;
    }

    public void erase(String word) {
        TrieNode2 node = root;
        for(char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            node = node.links[charIndex];
            node.wordsStartingHere--;
        }
        node.wordsEndingHere--;
    }
}
