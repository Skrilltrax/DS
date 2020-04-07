class Solution {
public:
    bool findHappy(int n, unordered_set<int> &set) {
        if (n == 1) {
            return true;
        }
        
        if (set.count(n) > 0) {
            return false;
        } else {
            set.insert(n);
        }
        
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        
        bool res = false;
        res = res || findHappy(sum, set);
        
        return res;
    }
    
    bool isHappy(int n) {
        unordered_set<int> set;
        return findHappy(n, set);
    }
};
