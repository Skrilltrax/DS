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
    
    void makeVec(TreeNode* root, vector<vector<int>> &vec, int level) {
        if (root == nullptr)
            return;
        
        if (level >= vec.size()) {
            vector<int> invec;
            invec.push_back(root->val);
            vec.push_back(invec);
        } else {
            vector<int> invec = vec[level];
            invec.push_back(root->val);
            vec[level] = invec;
        }
        
        makeVec(root->left, vec, level + 1);
        makeVec(root->right, vec, level + 1);
    }
    
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> vec;
        if (root == nullptr) return vec;
        makeVec(root, vec, 0);
        reverse(vec.begin(), vec.end());
        return vec;
    }
};
