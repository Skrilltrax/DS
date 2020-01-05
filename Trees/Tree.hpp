#include <bits/stdc++.h>
#include "TreeNode.hpp"
using namespace std;

template <typename T>
class Tree {
    
    TreeNode<T>* tree;

    TreeNode<T>* createNodesDF();
    TreeNode<T>* createNodesBF();
    void printTreeBF(TreeNode<T>* tree);

    public:

    TreeNode<T>* getTree() {
        return tree;
    }

    void createTreeDF() {
        tree = createNodesDF();
    }

    void createTreeBF() {
        tree = createNodesBF();
    }

    void printTree() {
        printTreeBF(tree);
    }
};

template <typename T>
TreeNode<T>* Tree<T>::createNodesDF() {
    int val, nodes;
    cout << "Enter data : ";
    cin >> val;
    cout << "Enter no of nodes : ";
    cin >> nodes;
    TreeNode<T>* newTree = new TreeNode<T>(val);
    for (int i = 0; i < nodes; i++) {
        TreeNode<T>* child = createNodesDF();
        newTree -> children.push_back(child);
    }
    return newTree;
}

template <typename T>
TreeNode<T>* Tree<T>::createNodesBF() {
    int val, nodes, num;
    cout << "Enter data : ";
    cin >> val;
    TreeNode<T>* newTree = new TreeNode<T>(val);

    queue<TreeNode<T>*> pendingNodes;
    pendingNodes.push(newTree);

    while (pendingNodes.size() != 0)
    {
        TreeNode<int>* front = pendingNodes.front();
        pendingNodes.pop();
        cout << "Enter no of children of " << front -> data << " : ";
        cin >> num;
        for (int i = 0; i < num; i++) {
            int childData;
            cout << "Enter child " << i << " of " << front -> data << " : ";
            cin >> childData;
            TreeNode<T>* child = new TreeNode<T>(childData);
            front->children.push_back(child);
            pendingNodes.push(child);
        }
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
