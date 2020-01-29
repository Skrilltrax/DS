package questions;

public class WordBreak {

    public static String[] dict = {"I", "Like", "Sam", "Sung", "SamSung"};

    public static boolean checkWord(String str) {
        for (int i = 0; i < dict.length; i++)
            if (str.equals(dict[i])) {
                return true;
            }
        return false;
    }

    public static int breakWord(String ques, String ans) {
        System.out.println("Ques : " + ques);
        if (ques.length() == 1) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < ques.length(); i++) {
            // String nstr = ques.substring(0, i); 
            // if (i == ques.length() - 1) {
                String nstr = ques.substring(0, i) + ques.charAt(i);
            // }
            System.out.println("Debug : " + nstr);
            if (checkWord(nstr)) {
                count += breakWord(ques.substring(i), ans + " " + nstr);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        breakWord("ILikeSamSung", "");
    }
}