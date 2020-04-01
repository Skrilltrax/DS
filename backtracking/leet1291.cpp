class Solution {
public:
    
    void findRec(long long currNum, long long prev, long long low, long long high, vector<int> &vec) {
        if (prev > 9) {
            return;
        } else if (currNum > high) {
            return;
        }
        
        long long thisNum = currNum * 10 + prev;
        
        if (thisNum >= low && thisNum <= high) {
            vec.push_back(thisNum);
        }
        
        findRec(thisNum, prev + 1, low, high, vec);
    }
    
    vector<int> sequentialDigits(int low, int high) {
        vector<int> ans;
        for (int i = 1; i <= 8; i++) {
            findRec(0, i, low, high, ans);
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};
