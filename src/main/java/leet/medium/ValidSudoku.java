package leet.medium;


import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        int len  = 9;
//      initialize
        HashSet<Character>[] rows = new HashSet[len];
        HashSet<Character>[] cols = new HashSet[len];
        HashSet<Character>[] boxes = new HashSet[len];
        for(int i = 0 ; i < len ; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
//      evaluate
        for(int r = 0 ; r < len ; r++) {
            for(int c = 0 ; c < len ; c++) {
                char val = board[r][c];
                if(val == '.') continue;
                if(rows[r].contains(board[r][c])) return false;
                rows[r].add(board[r][c]);
                if(cols[c].contains(board[r][c])) return false;
                cols[c].add(board[r][c]);
                int idx = ( r / 3 ) * 3 + ( c / 3 );
                if(boxes[idx].contains(board[r][c])) return false;
                boxes[idx].add(board[r][c]);
            }
        }
        return true;
    }
}

/*
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.

Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

 */