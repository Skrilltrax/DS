package questions;

public class RatInMaze {

    static boolean[][] board = { { false, true, true, true }, { false, false, true, false },
            { true, false, true, true }, { false, false, false, false } };

    public static int[][] fillDir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // U, D, L, R
    public static String[] path = { "U", "D", "L", "R" }; // U, D, L, R

    public static boolean isSafe(boolean[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c])
            return false;
        return true;
    }

    public static int ratInMaze(boolean[][] board, int sr, int sc, int er, int ec, String ans) {

        if (board[sr][sc]) {
            return 0;
        }

        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }


        int count = 0;
        board[sr][sc] = true;

        for (int i = 0; i < fillDir.length; i++) {

            int nsr = sr + fillDir[i][0];
            int nsc = sc + fillDir[i][1];
            
            if (isSafe(board, nsr, nsc)) {
                count += ratInMaze(board, nsr, nsc, er, ec, ans + path[i] + " ");
            }
        }
        board[sr][sc] = false;
        return count;
    }

    public static void main(String[] args) {
        ratInMaze(board, 0, 0, 3, 3, "");
    }
}