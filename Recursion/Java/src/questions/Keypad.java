package questions;

import java.util.ArrayList;

public class Keypad {

    public static String[] keys =
            {"$^%", ";:.,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", "+-/", "@#*"};


    /**
     * 
     * @param nums Numbers for which words are to be found.
     * @param ans  Final answer to be printed at the end.
     * @return Total number of possible outcomes
     */
    public static int printKeys(String nums, String ans) {
        if (nums.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int number = nums.charAt(0) - '0';
        String word = keys[number];
        for (int i = 0; i < word.length(); i++) {
            count += printKeys(nums.substring(1), ans + word.charAt(i));
        }

        return count;
    }

    /**
     * 
     * @param nums Numbers for which words are to be found.
     * @param ans  Final answer to be printed at the end.
     * @return Total number of possible outcomes
     */
    public static int printKeysCombined(String nums, String ans) {
        if (nums.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int number = nums.charAt(0) - '0';
        String word = keys[number];

        for (int i = 0; i < word.length(); i++) {
            count += printKeysCombined(nums.substring(1), ans + word.charAt(i));
        }

        if (nums.length() > 1) {
            number = number * 10 + (nums.charAt(1) - '0');
            if (number >= 10 && number <= 11) {
                word = keys[number];
                for (int i = 0; i < word.length(); i++) {
                    count += printKeysCombined(nums.substring(2), ans + word.charAt(i));
                }
            }
        }
        return count;
    }

    public static ArrayList<String> getKeysCombined(String nums) {
        if (nums.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        int number = nums.charAt(0) - '0';
        String words = keys[number];

        ArrayList<String> recAns = getKeysCombined(nums.substring(1));
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length(); i++) {
            for (String s : recAns) {
                ans.add(words.charAt(i) + s);
            }
        }

        if (nums.length() > 1) {
            number = number * 10 + (nums.charAt(1) - '0');
            if (number >= 10 && number <= 11) {
                words = keys[number];
                recAns = (getKeysCombined(nums.substring(2)));
                for (int i = 0; i < words.length(); i++) {
                    for (String s : recAns) {
                        ans.add(words.charAt(i) + s);
                    }
                }
            }
        }

        return ans;
    }
}

