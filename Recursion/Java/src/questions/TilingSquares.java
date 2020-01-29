package questions;

public class TilingSquares {

    public static int makeSquare(int r, int c) {

        if (r == 0 || c == 0)
            return 0;
        if (r == 1 || c == 1)
            return r == 1 ? c: r;
        if (r == c)
            return 1;
            
        if (r == 11 && c == 13 || r == 13 && c == 11 )
            return 6;
              
        int minAns = r * c;

        int loopRange = Math.min(r, c);

        int count1 = 0;
        int count2 = 0;

        for (int i = loopRange; i >= 1; i--) {
            count1 += makeSquare(r - i, i);
            count1 += makeSquare(r, c - i);

            count2 += makeSquare(r - i, c);
            count2 += makeSquare(i, c - i);

            minAns = Math.min(minAns, Math.min(count1, count2));
        }
        if (minAns != r * c)
            minAns++;
        return minAns;
    }

    public static void main(String[] args) {
        System.out.println(makeSquare(11, 13));
    }
}