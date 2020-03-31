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
    int sum = 0;
    void findSum(TreeNode* root, bool isLeft) {
        if (root == nullptr) {
            return;
        }
        
        if (isLeft && root->left == nullptr && root->right == nullptr) {
            sum += root->val;
        }
        
        findSum(root->left, true);
        findSum(root->right, false);
        
    }
    int sumOfLeftLeaves(TreeNode* root) {
        findSum(root, false);
        return sum;
    }
};
