class Solution {
public:
    int maxSum = -1;
    
    int robHouses(vector<int> &nums, int index, int sums, vector<int> &dp) {
        if (index >= nums.size()) {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        for(int i = index; i < nums.size(); i++) {
            int res = robHouses(nums, i + 2, sums + nums[i], dp);
            if (res + nums[i] > dp[index]) {
                dp[index] = res + nums[i];
            }
        }
        
        return dp[index];
    }
    
    int rob(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        
        vector<int> dp(nums.size(), -1);
        robHouses(nums, 0, 0, dp);
        for(int i = 0; i < dp.size(); i++) {
            if (maxSum < dp[i]) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }
};
