
public class LongestSubsequences {

    public static int LIS(int[] arr, int[] dp) {
        n = arr.length;
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i]++;
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
    
    public static int LIS_Rec(int[] arr, int[] dp) {
        n = arr.length;
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i]++;
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }


    public static int LDS(int[] arr, int[] dp) {
        n = arr.length;
        dp[n-1] = 1;
        int maxLen = 1;
        for (int i = n-2; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i]++;
            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }

    public static int LBS(int[] arr) {
        int[] lisArr = new int[arr.length];
        int[] ldsArr = new int[arr.length];
        int[] lbsArr = new int[arr.length];

        LIS(arr, lisArr);
        LDS(arr, ldsArr);

        int max = 1;

        for (int i = 0; i < arr.length; i++) {
            lbs[i] = lis[i] + lds[i] - 1;
            max = Math.max(max, lbs[i]);
        }

        return max;
    }

    public static int MaxSumIncreasingSubseq(int[] arr, int[] dp) {
        int n = arr.length;
        dp[0] = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += arr[i];
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }
}