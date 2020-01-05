#include <bits/stdc++.h>
#include "Tree.hpp"

int countNodes(TreeNode<int>* root) {
    if (root == NULL) {
        return 0;
    }
    int sum = 0;
    if (root -> children.size() == 0) {
        sum = 1;
    }
    for (int i = 0; i < root -> children.size(); i++) {
        sum += countNodes(root -> children[i]);
    }
    return sum;
}

int main() {
    Tree<int> treeHelper;
    treeHelper.createTreeBF();
    TreeNode<int>* tree = treeHelper.getTree();
    cout << "No of Leaves : " << countNodes(tree);
    return 0;
}