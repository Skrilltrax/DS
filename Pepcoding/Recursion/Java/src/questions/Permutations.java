package questions;

import java.util.ArrayList;
import java.util.Collections;

public class Permutations {

    public static int permutationBad(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String nStr = str.substring(0, i) + str.substring(i + 1);
            count += permutationBad(nStr, ans + ch);
        }
        return count;
    }

    /**
     * * Permutation that handles repitition too.
     * 
     * @param str string for permutation
     * @param ans final result of each tree
     * @return total number of possible result ble permutations without repitition
     */

    public static int permutationGood(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        
        ArrayList<Boolean> visited = new ArrayList<>(Collections.nCopies(26, false));

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (!visited.get(ch - 'a')) {
                visited.set((ch - 'a'), true);
                String nstr = str.substring(0, i) + str.substring(i+1);
                count += permutationGood(nstr, ans + ch);
            }
        
        }
        return count;
    }

    public static void main(String[] args) {
        permutationBad("abc", "");
    }
}
