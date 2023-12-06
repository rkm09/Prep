package leet.simple;

public class NumberOfMatches1688 {
    public static void main(String[] args) {
        System.out.println(numberOfMatches1(7));
    }

//    time: O(1), space: O(1)
    public static int numberOfMatches1(int n) {
        return n-1;
    }

//    [def] time: O(log2n), space: O(1) :: at each step we divide by n
    public static int numberOfMatches(int n) {
        int ans = 0, rdr;
        while(n != 1) {
            rdr = n % 2;
            n /= 2;
            ans += n;
            n += rdr;
        }
        return ans;
    }
}

/*
You are given an integer n, the number of teams in a tournament that has strange rules:
If the current number of teams is even, each team gets paired with another team. A total of n / 2 matches are played, and n / 2 teams advance to the next round.
If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
Return the number of matches played in the tournament until a winner is decided.
Example 1:
Input: n = 7
Output: 6
Explanation: Details of the tournament:
- 1st Round: Teams = 7, Matches = 3, and 4 teams advance.
- 2nd Round: Teams = 4, Matches = 2, and 2 teams advance.
- 3rd Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
Total number of matches = 3 + 2 + 1 = 6.
Example 2:

Input: n = 14
Output: 13
Explanation: Details of the tournament:
- 1st Round: Teams = 14, Matches = 7, and 7 teams advance.
- 2nd Round: Teams = 7, Matches = 3, and 4 teams advance.
- 3rd Round: Teams = 4, Matches = 2, and 2 teams advance.
- 4th Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
Total number of matches = 7 + 3 + 2 + 1 = 13.
Constraints:
1 <= n <= 200

Instead of simulating the entire tournament, here we will directly consider the beginning and end of the tournament.
In this tournament, when a team loses, they are eliminated and will no longer play any matches.
There are n teams, and 1 winner. Thus, n - 1 teams will be eliminated.
Each match is played between two teams. One team wins, one team loses. Thus, each match eliminates exactly one team.
As n - 1 teams will be eliminated, there will be n - 1 matches played, with each match eliminating a team.
 */