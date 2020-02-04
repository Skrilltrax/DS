package questions;

public class Coins {

    public static int coinCombination(int[] coins, int index, int target, String ans) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = index; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                count += coinCombination(coins, i + 1, target - coins[i], ans + coins[i]);
            }
        }
        return count;
    }

    public static int coinInfiniteCombination(int[] coins, int index, int target, String ans) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = index; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                count += coinInfiniteCombination(coins, i, target - coins[i], ans + coins[i]);
            }
        }
        return count;
    }

    public static int coinCombinationAlt(int[] coins, int index, int target, String ans) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        
        if (index == coins.length) {
            return 0;
        }

        int count = 0;
        if (target - coins[index] >= 0) {
            coinCombinationAlt(coins, index + 1, target - coins[index], ans + coins[index]);
        }
        coinCombinationAlt(coins, index + 1, target, ans);

        return count;
    }

    public static int coinInfiniteCombinationAlt(int[] coins, int index, int target, String ans) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        if (index == coins.length) {
            return 0;
        }

        int count = 0;
        if (target - coins[index] >= 0) {
            count += coinInfiniteCombinationAlt(coins, index, target - coins[index], ans + coins[index]);
        }
        count += coinInfiniteCombinationAlt(coins, index + 1, target, ans);
        
        return count;
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        // System.out.println(Arrays.asList(arr));
        // ArrayList<Integer> coins = Arrays.asList(0, 2, 3, 5, 7);
        // coinInfiniteCombination(coins, 0, 10, "");
        // coinCombinationAlt(coins, 0, 10, "");
        coinInfiniteCombinationAlt(coins, 0, 10, "");
    }
}