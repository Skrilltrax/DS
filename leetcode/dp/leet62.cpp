class Solution {
public:
    
    vector<vector<int>> moves = {{1, 0}, {0, 1}}; // D R
    
    bool isSafe(int sr, int sc, int m, int n) {
        if (sr < 0 || sc < 0 || sr >= m || sc >= n) {
            return false;
        }
        return true;
    }
    
    int solveRecursive(int sr, int sc, int dr, int dc, vector<vector<int>>& dp) {
        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        
        if (sr == dr && sc == dc) {
            return 1;
        }
        
        int res = 0;
        
        for(int i = 0; i < moves.size(); i++) {
            int nr = sr + moves[i][0];
            int nc = sc + moves[i][1];
            
            if(isSafe(nr, nc, dr + 1, dc + 1)) {
                res += solveRecursive(nr, nc, dr, dc, dp);    
            }
        }
        
        dp[sr][sc] = res;
        return res;
    }
    
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m, vector<int>(n, 0));
        return solveRecursive(0, 0, m-1, n-1, dp);
    }
};
