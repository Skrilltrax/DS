package questions;

public class Subsequence {

    public static int subseqComb(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        String nstr = str.substring(1);
        char ch = str.charAt(0);
        
        count += subseqComb(nstr, ans + ch);
        count += subseqComb(nstr, ans);
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(subseqComb("abc", ""));
    }

}