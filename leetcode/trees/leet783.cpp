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
    int min = INT_MAX;
    int prev = -1;
    void getMin(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        getMin(root->left);
        if (prev != -1) {
            int tmp = abs(root->val - prev);
            if (tmp < min) {
                min = tmp;
            }
        }
        prev = root->val;
        getMin(root->right);
    }
    int minDiffInBST(TreeNode* root) {
        getMin(root);
        return min;
    }
};
