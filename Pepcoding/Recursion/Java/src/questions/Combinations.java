package questions;

public class Combinations {

    public static int combination(String ques, int currMembers, String ans) {
        if (currMembers == ques.length()) {
            System.out.println(ans);
            return 1;
        }

        int count = 1;
        System.out.println(ans);
        for (int i = currMembers; i < ques.length(); i++) {
            count += combination(ques, i + 1, ans + ques.charAt(i));
        }
        return count;
    }

    public static int combinationII(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        String nques = ques.substring(1);

        count += combinationII(nques, ans);
        count += combinationII(nques, ans + ques.charAt(0));

        return count;
    }

    public static void main(String[] args) {
        // System.out.println(combination("abc", 0, ""));
        // combinationII("abc", "");
    }
}