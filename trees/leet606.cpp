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
    string makeStr(TreeNode* t) {
        if (t == nullptr) {
            return "";
        }

         if (t->left == nullptr && t->right == nullptr) {
            return to_string(t->val);
        }

        string str = to_string(t->val);

        string left = makeStr(t->left);
        string right = makeStr(t->right);

        str += "(" + left + ")";

        if (right != "") {
            str += "(" + right + ")";
        }

        return str;
    }

    string tree2str(TreeNode* t) {
        string s = makeStr(t);
        return s;
    }
};
