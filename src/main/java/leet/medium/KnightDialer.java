package leet.medium;

public class KnightDialer {
    static int moves;
    static int[][] memo;
    static final int MOD = (int) 1e9 + 7;
    static int[][] jumps = {
            {4,6},
            {6,8},
            {7,9},
            {4,8},
            {3,9,0},
            {},
            {1,7,0},
            {2,6},
            {1,3},
            {2,4}
    };
    public static void main(String[] args) {
        System.out.println(knightDialer(1));
    }
    public static int knightDialer(int n) {
        moves = n;
        memo = new int[n+1][10];
        int ans = 0;
        for(int square = 0 ; square < 10 ; square++) {
            ans = (ans + dp(n-1, square)) % MOD;
        }
        return ans;
    }
    public static int dp(int remain, int square) {
        if(remain == 0) {
            return 1;
        }
        if(memo[remain][square] != 0) {
            return memo[remain][square];
        }
        int ans = 0;
        for(int nextSquare : jumps[square]) {
            ans = (ans + dp(remain - 1, nextSquare)) % MOD;
        }
        memo[remain][square] = ans;
        return ans;
    }
}

/*
The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L).
We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell.
Given an integer n, return how many distinct phone numbers of length n we can dial.
You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n. All jumps should be valid knight jumps.
As the answer may be very large, return the answer modulo 10^9 + 7.
 1 | 2 | 3
 4 | 5 | 6
 7 | 8 | 9
 * | 0 | #
Example 1:
Input: n = 1
Output: 10
Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
Example 2:
Input: n = 2
Output: 20
Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
Example 3:
Input: n = 3131
Output: 136006598
Explanation: Please take care of the mod.
Constraints:
1 <= n <= 5000
 */