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
                count += placeQueens2DI(boxes, i + 1, totalQueens, queensPlaced + 1,
                ans + "(" + r + ", " + c + ") ");
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
                count += placeQueens2DPermI(boxes, 0, totalQueens, queensPlaced + 1,
                ans + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }
        }

        return count;
    }


    
    public boolean isQueenSafeII() {
        return false;
    }

    public static int placeQueens2DII() {
        
    }

    public static void main(String[] args) {
        // placeQueens1D(4, 0, 3, 0, "");
        boolean[][] boxes = new boolean[4][4];
        // System.out.println(placeQueens2DPermI(boxes, 0, 4, 0, ""));
    }
}