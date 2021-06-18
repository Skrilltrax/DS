package questions;

public class PrintQues {

    public static void printIncr(int a, int b) {
        if (a > b)
            return;
        System.out.println(a);
        printIncr(a++, b);
    }

    public static int[] allIndex(int[] a, int b, int index, int count) {
        if (index == a.length) {
            int[] base = new int[count];
            return base;
        }

        if (a[index] == b)
            count++;

        int[] ans = allIndex(a, b, index + 1, count);

        if (a[index] == b)
            ans[count - 1] = index;

        return ans;
    }
}
