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
    
    void makePaths(TreeNode* root, vector<string> &vec, string path) {
        if (root == nullptr)
            return;
        if (root->left == nullptr && root->right == nullptr) {
            vec.push_back(path + to_string(root->val));
            return;
        }
        
        makePaths(root->left, vec, path + to_string(root->val) + "->");
        makePaths(root->right, vec, path + to_string(root->val) + "->");
    }
    
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> vec;
        if (root == nullptr)
            return vec;
        makePaths(root, vec, "");
        return vec;
    }
};
