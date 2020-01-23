package questions;

public class Power {

    public static int powerBad(int a, int b) {
        if (a == 0)
            return 0;
        if (b == 0)
            return 1;
        return a * powerBad(a, b - 1);
    }

    public static int powerGood(int a, int b) {
        if (a == 0)
            return 0;
        if (b == 0)
            return 1;
        int smallAns = powerGood(a, b / 2);
        int ans = smallAns * smallAns;
        return (b % 2 == 0) ? ans : ans * a;
    }
}
