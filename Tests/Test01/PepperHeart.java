import java.io.*;
import java.util.*;

public class PepperHeart {

    public static void takeInput() {
    
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int uplines = 0;
        int uplinspc = 0;
        int maxStars = 0;
        if (k % 2 == 0) {
            uplinspc = k - 1;
            uplines = k/2;
            maxStars = 3*k + 1;
        } else {
            uplinspc = k;
            uplines = k/2 + 1;
            maxStars = 3*k;
        }
        
        
        for (int i = 0; i < uplinspc; i+= 2, uplines--) {
            for (int j = 1; j < uplines; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < k + i; j++) {
                System.out.print("*");
            }
            
            for (int j = i; j < uplinspc; j++) {
                System.out.print(" ");
            }
            
            for (int j = 0; j < k + i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i = 0, j = 0; i < maxStars; i+= 2, j++) {
            for (int f = 0; f < j; f++) {
                System.out.print(" ");
            }
            for (int f = i; f < maxStars; f++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        takeInput();
    }
} 
