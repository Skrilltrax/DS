public class BasicQues {

    public static int fac(int n) {
        if (n <= 1)
            return 1;
        return n * fac(n - 1);
    }

    public static powBad(int a, int b) {
        if (b == 0)
            return 1;
        if (a == 0)
            return 0;
        return a * pow(b - 1);
    }

    public static powGood(int a, int b) {
        if (b == 0)
            return 1;
        if (a == 0)
            return 0;
        int smallAns = pow(a, b/2);
        return smallAns * smallAns * a;
    }
}
