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
