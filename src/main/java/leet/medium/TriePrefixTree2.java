package leet.medium;

import datastructures.trie.Trie2;

public class TriePrefixTree2 {
    public static void main(String[] args) {
        Trie2 obj = new Trie2();
        String word = "apple";
        obj.insert(word);
        int count = obj.countWordsEqualTo(word);
        int startc = obj.countWordsStartingWith("a");
        System.out.println(count);
        System.out.println(startc);
        obj.erase(word);
    }
}

/*
This problem takes the concept of a Trie a step further and introduces more advanced operations that involve computing counts based on certain conditions.
The methods include counting the number of words that start with a given prefix and counting the total number of words that match a given word.
Additionally, this problem requires you to erase a word from the trie.
This problem not only requires a solid understanding of basic Trie operations but also challenges you to optimize counting operations by cleverly using counters and taking advantage of the Trie's structure to reduce unnecessary traversal.

Complexity Analysis
Let N be the maximum length of a word or a prefix.
Let M be the number of calls.
Time complexity: O(N). The time complexity for each method is O(N) since we iterate over the characters of the word.
Space complexity: O(N⋅M). Each character can create a new node in the trie when the insert method is called.
For a word of length N we will create at most N TrieNodes. If there are M words inserted into the trie we will have to create at most N⋅M TrieNodes.
 */
