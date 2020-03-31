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
    void makeVec(TreeNode* root, vector<int> &vec) {
        if (root == nullptr)
            return;

        makeVec(root->left, vec);
        vec.push_back(root->val);
        makeVec(root->right, vec);
    }

    bool findTarget(TreeNode* root, int k) {
        if (root == nullptr) return false;
        vector<int> vec;
        makeVec(root, vec);
        int i = 0;
        int j = vec.size() - 1;
        while(i < j) {
            if (vec[i] + vec[j] == k) {
                return true;
            } else if (vec[i] + vec[j] > k) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
    //==================================================
    // Set soln.

    bool find(TreeNode* root, unordered_set<int> &set, int k) {
        if (root == nullptr)
            return false;

        if (set.count(k - root->val) > 0) {
            return true;
        } else {
            set.insert(root->val);
        }

        return find(root->left, set, k) || find(root->right, set, k); 
    }

    bool findTarget(TreeNode* root, int k) {
        if (root == nullptr) return false;
        unordered_set<int> set;
        return find(root, set, k);
    }
};
