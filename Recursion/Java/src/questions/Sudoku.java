package questions;

public class Sudoku {

    public static int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
    public static int[][] mat = new int[3][3];
    public static int[] row = new int[9];
    public static int[] col = new int[9];

    public static void createBoard() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != 0) {
                    int mask = 1 << board[i][j];
                    if ((row[i] & mask) == 0 && (col[j] & mask) == 0 && (mat[i / 3][j / 3] & mask) == 0) {
                        row[i] |= mask;
                        col[j] |= mask;
                        mat[i / 3][j / 3] |= mask;
                    } else {
                        return;
                    }
                }
            }
        }

    }

    public static int fill(int boxNo) {
        if (boxNo == 81) {
            for (int[] arr : board) {
                for (int ele : arr) {
                    System.out.print(ele + " ");
                }
                System.out.println();
            }
            return 1;
        }

        int count = 0;
        int i = boxNo / 9;
        int j = boxNo % 9;
        if (board[i][j] == 0) {
            for (int num = 1; num <= 9; num++) {
                int mask = 1 << num;
                if ((row[i] & mask) == 0 && (col[j] & mask) == 0 && (mat[i / 3][j / 3] & mask) == 0) {

                    row[i] ^= mask;
                    col[j] ^= mask;
                    mat[i / 3][j / 3] ^= mask;
                    board[i][j] = num;

                    count += fill(boxNo + 1);

                    row[i] ^= mask;
                    col[j] ^= mask;
                    mat[i / 3][j / 3] ^= mask;
                    board[i][j] = 0;

                }
            }
        } else {
            count += fill(boxNo + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        createBoard();
        System.out.println(fill(0));
        // for (int i = 0; i < 9; i++)
        // System.out.println(row[i]);
    }

}