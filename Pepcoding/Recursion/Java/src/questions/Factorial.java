package questions;

public class Factorial {

    public static int fac(int n) {
        if (n == 0)
            return 1;
            
        return n * fac(n - 1);
    }
}