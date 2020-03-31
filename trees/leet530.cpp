/**
 * Definition for a binary tree node.
 * struct TreeNode {
 * int val;
 * TreeNode *left;
 * TreeNode *right;
 * TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {

public:
    void getMinBad(TreeNode* root, vector<int> &vec) {
        if (root == nullptr) {
            return;
        }
        getMin(root->left, vec);
        vec.push_back(root->val);
        getMin(root->right, vec);
    }

    int getMinimumDifferenceBad(TreeNode* root) {
        vector<int> vec;
        getMinBad(root, vec);
        int min = INT_MAX;

        for(int i = 1; i < vec.size(); i++) {
            if(vec[i]-vec[i-1] < min) {
                min = vec[i]-vec[i-1];
            }
        }
        return min;
    }

   //================================================================
   // Better Sol.

    int prev = -1;
    int min = INT_MAX;

    void getMin(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        getMin(root->left);
        if (prev != -1) {
            if (abs(root->val - prev) < min) {
                min = abs(root->val - prev);
            }
        }

        prev = root->val;
        getMin(root->right);
    }

    int getMinimumDifference(TreeNode* root) {
        getMin(root);
        return min;
    }

};


