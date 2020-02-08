package questions;

public class NQueens {

    static int[][] queenMoves = { { 0, -1 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 0, 1 }, { 1, 0 }, { 1, 1 },
            { 1, -1 } };

    public static int placeQueens1D(int boxSize, int index, int totalQueens, int queensPlaced, String ans) {
        if (boxSize < totalQueens) {
            return -1;
        }
        if (queensPlaced == totalQueens) {
            System.out.println(ans);
            return 1;
        }
        if (index >= boxSize) {
            return 0;
        }

        int count = 0;

        for (int i = index; i < boxSize; i++) {
            count += placeQueens1D(boxSize, i + 1, totalQueens, queensPlaced + 1,
                    ans + "B" + i + "Q" + queensPlaced + " ");
        }

        return count;
    }

    public static int placeQueens1DAlt(int boxSize, int index, int totalQueens, int queensPlaced, String ans) {
        if (boxSize < totalQueens) {
            return -1;
        }
        if (queensPlaced == totalQueens) {
            System.out.println(ans);
            return 1;
        }
        if (index >= boxSize) {
            return 0;
        }

        int count = 0;

        count += placeQueens1DAlt(boxSize, index + 1, totalQueens, queensPlaced + 1,
                ans + "B" + index + "Q" + queensPlaced + " ");
        count += placeQueens1DAlt(boxSize, index + 1, totalQueens, queensPlaced, ans);

        return count;
    }

    public static boolean isQueenSafeI(boolean[][] boxes, int r, int c) {
        for (int i = 0; i < queenMoves.length; i++)
            for (int jump = 1; jump <= boxes.length; jump++) {
                int nr = r + jump * queenMoves[i][0];
                int nc = c + jump * queenMoves[i][1];
                if (nr >= 0 && nc >= 0 && nr < boxes.length && nc < boxes[0].length) {
                    if (boxes[nr][nc])
                        return false;
                } else
                    break;
            }
        return true;
    }

    public static int placeQueens2DI(boolean[][] boxes, int boxNo, int totalQueens, int queensPlaced, String ans) {
        if (queensPlaced == totalQueens) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = boxNo; i < boxes[0].length * boxes.length; i++) {

            int r = i / boxes[0].length;
            int c = i % boxes[0].length;

            if (!boxes[r][c] && isQueenSafeI(boxes, r, c)) {
                boxes[r][c] = true;
                count += placeQueens2DI(boxes, i + 1, totalQueens, queensPlaced + 1, ans + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }
        }

        return count;
    }

    public static int placeQueens2DPermI(boolean[][] boxes, int boxNo, int totalQueens, int queensPlaced, String ans) {
        if (queensPlaced == totalQueens) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < boxes[0].length * boxes.length; i++) {

            int r = i / boxes[0].length;
            int c = i % boxes[0].length;

            if (!boxes[r][c] && isQueenSafeI(boxes, r, c)) {
                boxes[r][c] = true;
                count += placeQueens2DPermI(boxes, 0, totalQueens, queensPlaced + 1, ans + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }
        }

        return count;
    }

    public static boolean[] rowArray;
    public static boolean[] colArray;
    public static boolean[] diagArray;
    public static boolean[] antiDiagArray;

    public static boolean isQueenSafeII(int r, int c, int size) {
        if (rowArray[r] || colArray[c] || diagArray[r + c] || antiDiagArray[r - c + size - 1])
            return false;
        return true;
    }

    public static void markUnmarkArray(int r, int c, int size) {
        rowArray[r] = !rowArray[r];
        colArray[c] = !colArray[c];
        diagArray[r + c] = !diagArray[r + c];
        antiDiagArray[r - c + size - 1] = !antiDiagArray[r - c + size - 1];
    }

    public static int placeQueens2DII(int boxNo, int size, int queensPlaced, int totalQueens, String ans) {
        if (queensPlaced == totalQueens) {
            System.out.println(ans);
            return 1;
        }

        if (boxNo == size * size) {
            return 0;
        }

        int count = 0;
        for (int i = boxNo; i < size * size; i++) {
            int r = i / size;
            int c = i % size;

            if (isQueenSafeII(r, c, size)) {
                markUnmarkArray(r, c, size);
                count += placeQueens2DII(i + 1, size, queensPlaced + 1, totalQueens, ans + "(" + r + ", " + c + ") ");
                markUnmarkArray(r, c, size);
            }
        }
        return count;
    }

    public static void queen2D2(int size) {
        rowArray = new boolean[size];
        colArray = new boolean[size];
        diagArray = new boolean[2 * size - 1];
        antiDiagArray = new boolean[2 * size - 1];
        placeQueens2DII(0, size, 0, size, "");
    }

    public static int rowBit = 0;
    public static int colBit = 0;
    public static int diagBit = 0;
    public static int antiDiagBit = 0;

    public static boolean isQueenSafeIII(int r, int c, int size) {
        return ((rowBit & (1 << r)) == 0 && (colBit & (1 << c)) == 0 && (diagBit & (1 << (r + c))) == 0
                && (antiDiagBit & (1 << (r - c + size - 1))) == 0);
    }

    public static void markUnmarkBits(int r, int c, int size) {
        rowBit ^= 1 << r;
        colBit ^= 1 << c;
        diagBit ^= 1 << (r + c);
        antiDiagBit ^= 1 << (r - c + size - 1);
    }

    public static void markBits(int r, int c, int size) {
        rowBit |= 1 << r;
        colBit |= 1 << c;
        diagBit |= 1 << (r + c);
        antiDiagBit |= 1 << (r - c + size - 1);
    }

    public static void unmarkBits(int r, int c, int size) {
        rowBit &= ~(1 << r);
        colBit &= ~(1 << c);
        diagBit &= ~(1 << (r + c));
        antiDiagBit &= ~(1 << (r - c + size - 1));
    }

    public static int placeQueens2DIII(int boxNo, int size, int queensPlaced, int totalQueens, String ans) {
        if (queensPlaced == totalQueens) {
            System.out.println(ans);
            return 1;
        }
        if (boxNo == size * size) {
            return 0;
        }

        int count = 0;
        for (int i = boxNo; i < size * size; i++) {
            int r = i / size;
            int c = i % size;

            if (isQueenSafeIII(r, c, size)) {
                markUnmarkBits(r, c, size);
                count += placeQueens2DIII(i + 1, size, queensPlaced + 1, totalQueens, ans + "(" + r + ", " + c + ") ");
                markUnmarkBits(r, c, size);
            }
        }
        return count;
    }

    public static void queen2D3(int size) {
        // placeQueens2DIII(0, size, 0, size, "");
        placeQueens2DBest(0, size, 0, size, "");
    }

    public static int placeQueens2DBest(int row, int size, int queensPlaced, int totalQueens, String ans) {
        if (queensPlaced == totalQueens) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (isQueenSafeIII(row, i, size)) {
                markUnmarkBits(row, i, size);
                count += placeQueens2DBest(row + 1, size, queensPlaced + 1, totalQueens, ans + "(" + row + ", " + i + ") ");
                markUnmarkBits(row, i, size);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // placeQueens1D(4, 0, 3, 0, "");
        // boolean[][] boxes = new boolean[4][4];
        // System.out.println(placeQueens2DPermI(boxes, 0, 4, 0, ""));
        queen2D3(4);
    }
}