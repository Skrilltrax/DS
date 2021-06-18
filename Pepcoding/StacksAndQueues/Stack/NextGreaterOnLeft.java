import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterOnLeft {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int arr[] = new int[k];
        int curr = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> que = new Stack<Integer>();

        for (int i = k - 1; i >= 0; i--) {
            curr = arr[i];
            int j = 0;
            for (j = i; j >= 0; j--) {
                if (arr[j] > curr) {
                    que.add(arr[j]);
                    break;
                }
            }
            if (j == -1) {
                que.add(-1);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(que.peek() + " ");
            que.pop();
        }
        sc.close();
    }
}