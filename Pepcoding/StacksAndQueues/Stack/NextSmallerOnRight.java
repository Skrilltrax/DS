import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NextSmallerOnRight {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int arr[] = new int[k];
        int curr = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        Queue<Integer> que = new LinkedList<Integer>();

        for (int i = 0; i < k; i++) {
            curr = arr[i];
            int j = 0;
            for (j = i; j < k; j++) {
                if (arr[j] < curr) {
                    curr = arr[j];
                    que.add(arr[j]);
                }
            }
            if (j == k) {
                que.add(-1);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(que.peek() + " ");
            que.remove();
        }
        sc.close();
    }
}