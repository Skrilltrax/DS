#include <bits/stdc++.h>
#include "TreeNode.hpp"
using namespace std;

template <typename T>
class Tree {
    
    TreeNode<T>* tree;

    TreeNode<T>* createNodes();
    void printTreeBF(TreeNode<T>* tree);

    public:

    TreeNode<T>* getTree() {
        return tree;
    }

    void createTree() {
        tree = createNodes();
    }

    void printTree() {
        printTreeBF(tree);
    }
    
};

template <typename T>
TreeNode<T>* Tree<T>::createNodes() {
    int val, nodes;
    cout << "Enter data : ";
    cin >> val;
    cout << "Enter no of nodes : ";
    cin >> nodes;
    TreeNode<T>* newTree = new TreeNode<T>(val);
    for (int i = 0; i < nodes; i++) {
        TreeNode<T>* child = createNodes();
        newTree -> children.push_back(child);
    }
    return newTree;
}

template<typename T>
void Tree<T>::printTreeBF(TreeNode<T>* tree) {
    cout << tree -> data << " : ";
    for (int i = 0; i < tree -> children.size(); i++) {
        cout << tree -> children[i] -> data;
        if (i != tree -> children.size() - 1) {
        cout << ", ";
        }
    }
    cout << endl;
    for (int i = 0; i < tree -> children.size(); i++) {
        printTreeBF(tree -> children[i]); 
    }
}
