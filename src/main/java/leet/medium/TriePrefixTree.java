package leet.medium;

public class TriePrefixTree {
    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "apple";
        obj.insert(word);
        boolean isPresent = obj.search(word);
        boolean isPrefix = obj.startsWith(word);
        System.out.println(isPresent);
        System.out.println(isPrefix);
    }
}

/*
This problem focuses on building a basic Trie data structure and implementing its core functionalities.
The core methods include inserting words into the Trie and searching for words or prefixes.
It's a foundational problem that tests your ability to create and manipulate a Trie.
 */