/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    int maxLevel = -1;
    
    void getRightView(vector<int> &vec, TreeNode* root, int currLevel) {
        if (root == nullptr) return;
        if (currLevel > maxLevel) {
            vec.push_back(root -> val);
            maxLevel = currLevel;
        }
        
        getRightView(vec, root -> right, currLevel + 1);
        getRightView(vec, root -> left, currLevel + 1);
    }
    
    vector<int> rightSideView(TreeNode* root) {
        vector<int> vec;
        getRightView(vec, root, 0);
        return vec;
    }
};
