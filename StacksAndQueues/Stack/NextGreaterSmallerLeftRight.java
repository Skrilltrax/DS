import java.util.Scanner;
import java.util.Stack;

public class NextGreaterSmallerLeftRight {

    public static void ngor(int k, int[] arr) {
        Stack<Integer> st = new Stack();
        int[] ans = new int[k];
        
        for (int i = 0; i < k; i++) { // Reverse loop for left
            while (st.size() != 0 && (arr[i] > arr[st.peek()])) { // < for smaller
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }

        // Tp fill the remaining elements of the stack
        while(st.size() != 0) {
            ans[st.pop()] = -1;
        }

        for (int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    
    public static void ngol(int k, int[] arr) {
        Stack<Integer> st = new Stack();
        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            while(st.size() != 0 && arr[i] > arr[st.peek()]) {
                ans[st.pop()] = i;
            }
            st.push(i);
        }

        while(st.size() != 0) {
            ans[st.pop()] = -1;
        }

        for (int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    
    public static void nsor(int k, int[] arr) {
        Stack<Integer> st = new Stack();
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            while(st.size() != 0 && arr[i] < arr[st.peek()]) {
                arr[st.pop()] = i;
            }
            st.push(i);
        }

        while (st.size() != 0) {
            arr[st.pop()] = -1;
        }
        
        for (int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    
    public static void nsol(int k, int[] arr) {
        Stack<Integer> st = new Stack();
        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            while(st.size() != 0 && arr[i] < arr[st.peek()]) {
                arr[st.pop()] = i;
            }
            st.push(i);
        }

        while(st.size() != 0) {
            arr[st.pop()] = -1;
        }

        for (int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void takeInput() {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        ngor(k, arr);
    }

    public static void main(String[] args) {
        takeInput();
    }
}