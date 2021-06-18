class Solution {
public:
    int titleToNumber(string s) {
        int ans = 0;
        for(int i = s.size() - 1, j = 0; i >= 0; i--, j++) {
            int num = (s[i] - 'A') + 1;
            ans += num * pow(26, j);
        }
        
        return ans;
    }
};
