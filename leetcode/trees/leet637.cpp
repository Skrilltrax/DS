/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxLevel = 0;

    void findAvg(TreeNode* root, vector<pair<double, int>> &vec, int level) {
        if(root == nullptr)
            return;
        if (level >= vec.size()) {
            vec.push_back({root->val, 1});
        } else {
            pair<double, int> p = vec[level];
            p.first += root->val;
            p.second++;
            vec[level] = p;
        }

        findAvg(root->left, vec, level + 1);
        findAvg(root->right, vec, level + 1);
    }

    vector<double> averageOfLevels(TreeNode* root) {
        vector<pair<double, int>> vec;
        findAvg(root, vec, 0);
        vector<double> ans(vec.size(), 0.0);
        pair<double, int> p;
        for(int i = 0; i < ans.size(); i++) {
            p = vec[i];
            ans[i] = p.first/p.second;
        }
        return ans;
    }
};
