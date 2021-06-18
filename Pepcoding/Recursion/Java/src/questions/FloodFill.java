package questions;

public class FloodFill {

    public static int[][] fillDir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // U, D, L, R
    public static String[] path = { "U", "D", "L", "R" }; // U, D, L, R
    
    public static int[][] fillDirDiag = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, {-1, -1}, {-1, 1}, {1, -1}, {1, 1} }; // U, D, L, R, UL, UR, DL, DR
    public static String[] pathDiag = { "U", "D", "L", "R", "UL", "UR", "DL", "DR" }; // U, D, L, R

    public static boolean isSafe(boolean[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c])
            return false;
        return true;
    }

    public static int floodFill(boolean[][] board, int sr, int sc, int dr, int dc, String ans) {

        // Not important here, more important for Rat in a maze
        if (board[sr][sc] == true) {
            return 0;
        }

        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return 1;
        }

        board[sr][sc] = true;
        int count = 0;

        for (int i = 0; i < fillDirDiag.length; i++) {

            int nsr = sr + fillDirDiag[i][0];
            int nsc = sc + fillDirDiag[i][1];
            String dir = pathDiag[i];

            if (isSafe(board, nsr, nsc)) {
                count += floodFill(board, nsr, nsc, dr, dc, ans + dir + " ");
            }
        }
        board[sr][sc] = false;
        return count;
    }

    public static int floodFillAllJumps(boolean[][] board, int sr, int sc, int dr, int dc, String ans) {

        if ((sr == dr) && (sc == dc)) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        board[sr][sc] = true;

        for (int i = 0; i < fillDir.length; i++) {
            for (int jmp = 1; jmp < board.length; jmp++) {

                int nsr = sr + jmp * fillDir[i][0];
                int nsc = sc + jmp * fillDir[i][1];

                if (isSafe(board, nsr, nsc)) {
                    count += floodFillAllJumps(board, nsr, nsc, dr, dc, ans + path[i] + String.valueOf(jmp) + " ");
                } else {
                    break;
                }

            }
        }
        board[sr][sc] = false;
        return count;
    }

    public static void floodFillSet() {
        boolean board[][] = new boolean[3][3];
        System.out.println(floodFill(board, 0, 0, 2, 2, ""));
    }

    public static void main(String[] args) {
        floodFillSet();
    }

}