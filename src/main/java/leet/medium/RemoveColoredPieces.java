package leet.medium;

public class RemoveColoredPieces {
    public static void main(String[] args) {
        String colors = "AAABABB";
        String colors1 = "ABBBBBBBAAA";
        boolean isA = winnerOfGame(colors1);
        System.out.println(isA);
    }

//    time: O(n), space: O(1)
    public static boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;
        for(int i = 1 ; i < colors.length() - 1 ; i++) {
            if(colors.charAt(i-1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i+1)) {
                if(colors.charAt(i) == 'A') alice++;
                else bob++;
            }
        }
        return alice - bob >= 1;
    }
}

/*
There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'. You are given a string colors of length n where colors[i] is the color of the ith piece.

Alice and Bob are playing a game where they take alternating turns removing pieces from the line. In this game, Alice moves first.

Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'. She is not allowed to remove pieces that are colored 'B'.
Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'. He is not allowed to remove pieces that are colored 'A'.
Alice and Bob cannot remove pieces from the edge of the line.
If a player cannot make a move on their turn, that player loses and the other player wins.
Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.



Example 1:

Input: colors = "AAABABB"
Output: true
Explanation:
AAABABB -> AABABB
Alice moves first.
She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.
Now it's Bob's turn.
Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
Thus, Alice wins, so return true.

Input: colors = "AA"
Output: false

Input: colors = "ABBBBBBBAAA"
Output: false

Constraints:

1 <= colors.length <= 105
colors consists of only the letters 'A' and 'B'


When one player removes a letter, it will never create a new removal opportunity for the other player. For example, let's say you had "ABAA". If the "B" wasn't there, then Alice would have a new removal opportunity. However, the "B" can never be removed because of the rules of the game. This observation implies that at the start of the game, all moves are already available to both players.
The order in which the removals happen is irrelevant. This is a side effect of the previous observation. Let's say there was a section in the middle of the string "BAAAAAB". Alice has three removal choices here, "BA[A]AAAB", "BAA[A]AAB", and "BAAA[A]AB". However, her choice is irrelevant, because all three choices will result in "BAAAAB".
The only thing that matters is the number of moves available to both players at the start of the game.
Alice moves first, she must make at least one move more than Bob to win. That is, Alice wins if alice - bob >= 1.
 */