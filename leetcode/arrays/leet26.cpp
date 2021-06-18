class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int size = 0;
        int i = 0;
        int j = 1;
        for (;j < nums.size(); j++) {
            if (nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                size++;
                i++;
            }
        }
        return size+1;
    }
};
