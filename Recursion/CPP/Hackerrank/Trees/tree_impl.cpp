#include <iostream>
#include <vector>
#include "Tree.hpp"
using namespace std;

void printTree(TreeNode<int> *root) {
    if (root == NULL) {
        return;
    }
    cout << root -> data << " : ";
    for (int i = 0; i < root -> children.size(); i++) {
        cout << root -> children[i] -> data;
        if (i != root -> children.size() - 1) {
            cout << ", ";
        }
    }
    cout << endl;
    for (int i = 0; i < root -> children.size(); i++) {
        printTree(root -> children[i]);
    }
}

int main () {

    // TreeNode<int> *root = new TreeNode<int>(10);
    // root -> children.push_back(new TreeNode<int>(20));
    // root -> children.push_back(new TreeNode<int>(30));
    // root -> children.push_back(new TreeNode<int>(40));
    // printTree(treeHelper.getTree());
    
    Tree<int> treeHelper;
    treeHelper.createTreeBF();
    treeHelper.printTree();
}