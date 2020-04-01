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
    int minDep = INT_MAX;
    
    void getMinDepth(TreeNode* root, int dep) {
        if (root == nullptr)
            return;
        if (root->left == nullptr && root->right == nullptr && dep < minDep) {
            cout << root->val << " ";
            minDep = dep;
        } 
        
        getMinDepth(root->left, dep + 1);
        getMinDepth(root->right, dep + 1);
    }
    
    int minDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        getMinDepth(root, 1);
        return minDep;
    }
};
