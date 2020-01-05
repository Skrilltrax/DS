#include <bits/stdc++.h>
#include "Tree.hpp"

int countNodes(TreeNode<int>* root) {
    if (root == NULL) {
        return 0;
    }
    if (root -> children.size() == 0) {
        return 1;
    }
    int sum = 0;
    for (int i = 0; i < root -> children.size(); i++) {
        sum += countNodes(root -> children[i]);
    }
    return 1 + sum;
}

int main() {
    Tree<int> treeHelper;
    treeHelper.createTreeBF();
    TreeNode<int>* tree = treeHelper.getTree();
    cout << "No of Nodes : " << countNodes(tree);
    return 0;
}