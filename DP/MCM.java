public class MCM {

    public static int mcm_rec(int[] arr, int st, int end, int[][] dp) {
        if (st + 1 == end) return dp[st][end] = 0;
        
        if (dp[st][end] != -1) return dp[st][end];
        
        int min = Integer.MAX_VALUE;
        for (int cut = st + 1; cut < end; cut++) {

            int leftOptAns = mcm_rec(arr, st, cut, dp);
            int rightOptAns = mcm_rec(arr, cut, end, dp);
            
            min = Math.min(min, leftOptAns + (arr[st] * arr[cut] * arr[end]) + rightOptAns);
        }

        return dp[st][end] = min;
    }

    public static Pair mcm_rec_str(int[] arr, int st, int end, Pair[][] dp) {

        if (st + 1 == end) {
            Pair ans = new Pair();
            ans.val = 0;
            ans.str = (char)(st + 'a') + "";
            return ans;
        }

        if (dp[st][end].val != -1) return dp[st][end];
        
        Pair min = new Pair();
        min.val = Integer.MAX_VALUE;
        for (int cut = st + 1; cut < end; cut++) {

            Pair leftOptAns = mcm_rec_str(arr, st, cut, dp);
            Pair rightOptAns = mcm_rec_str(arr, cut, end, dp);
            
            if (min.val > leftOptAns.val + (arr[st] * arr[cut] * arr[end]) + rightOptAns.val) {
                min.val = leftOptAns.val + (arr[st] * arr[cut] * arr[end]) + rightOptAns.val;
                min.str = "(" + leftOptAns.str + rightOptAns.str + ")";
            }
        }

        return dp[st][end] = min;
    }

    public static void main(String[] args) {
        int p[] = {40, 20, 30, 10, 30};
        Pair[][] dp = new Pair[p.length][p.length];
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = new Pair();
            }
        }
        
        // System.out.println(mcm_rec(p, 0, p.length-1, dp));
        System.out.println(mcm_rec_str(p, 0, p.length-1, dp).str);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j].val + "\t");
            }
            System.out.println();
        }
    }
}