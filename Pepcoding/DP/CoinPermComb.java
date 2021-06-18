
public class CoinPermComb {

    public static int coinChangePermRepTab(int[] coins, int tar) {
        int[] dp = new int[tar + 1];
        dp[0] = 1;

        for (int t = 0; t <= tar; t++) {
            for (int c: coins) {
                if (t - c >= 0) {
                    dp[t] += dp[t-c];
                }
            }
        }

        return dp[tar];
    }

    public static int coinChangeCombRepTab(int[] coins, int tar) {
        int[] dp = new int[tar + 1];
        dp[0] = 1;

        for (int c: coins) {
            for (int t = 0; t <= tar; t++) {
                if (t - c >= 0) {
                    dp[t] += dp[t-c];
                }
            }
        }

        return dp[tar];
    }

    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 7};
        int tar = 10;
        System.out.println(coinChangePermRepTab(coins, tar)); 
        System.out.println(coinChangeCombRepTab(coins, tar));    
    }
}