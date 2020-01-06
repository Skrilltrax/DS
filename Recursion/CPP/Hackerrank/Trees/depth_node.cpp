#include <bits/stdc++.h>
#include "Tree.hpp"

void calculateDepth(TreeNode<int>* root, int level) {
    queue<TreeNode<int>*> pendingNodes;
    pendingNodes.push(root);
    cout << "Nodes at level " << level << " : ";
    while (pendingNodes.size() != 0)
    {
        if (level == 0) {
            while (pendingNodes.size() != 0) {
                cout << pendingNodes.front()  -> data << " ";
                pendingNodes.pop();
            }
        } else {
            int size = pendingNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode<int>* front = pendingNodes.front();
                pendingNodes.pop();
                for (int j = 0; j < front -> children.size(); j++)
                pendingNodes.push(front -> children[j]);
            }
            level--;
        }
    }  
} 

int main() {
    Tree<int> treeHelper;
    treeHelper.createTreeBF();
    TreeNode<int>* tree = treeHelper.getTree();
    calculateDepth(tree, 3);
    return 0;
}