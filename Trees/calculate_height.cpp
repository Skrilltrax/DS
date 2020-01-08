#include <bits/stdc++.h>
#include "Tree.hpp"

int calculateHeight(TreeNode<int>* root) {
    if (root == NULL) {
        return 0;
    }
    int max = INT_MIN;
    for (int i = 0; i < root -> children.size(); i++) {
        int height = calculateHeight(root -> children[i]);
        if (max < height) {
            max = height;
        }
    }
    if (max == INT_MIN) {
        return 1;
    }
    return 1 + max;
}

int main() {
    Tree<int> treeHelper;
    treeHelper.createTreeBF();
    TreeNode<int>* tree = treeHelper.getTree();
    cout << "Height : " << calculateHeight(tree);
    return 0;
}