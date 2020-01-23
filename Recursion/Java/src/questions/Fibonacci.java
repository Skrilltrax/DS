package questions;

public class Fibonacci {

    public static int fibo(int n) {
        if (n <= 1)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void printFibo(int n, int a, int b) {
        if (n == 0)
            return;
        System.out.println(a + " ");
        printFibo(n - 1, b, a + b);
    }
}
