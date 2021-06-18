#include "AVLNode.hpp"
#include "AVLRotations.hpp"
#include <iostream>
#include <string>
using namespace std;

void display(AVLNode *node)
{
    if (node == nullptr)
        return;

    cout << to_string(node->data) + ": ";
    string str = "";
    if (node->left != nullptr)
        str.append("L" + to_string(node->left->data) + ", ");
    if (node->right != nullptr)
        str.append("R" + to_string(node->right->data));
    cout << str << endl;

    display(node->left);
    display(node->right);
}

AVLNode *addNode(AVLNode *node, int data)
{
    if (node == nullptr)
    {
        AVLNode *node = new AVLNode(data, nullptr, nullptr);
        return node;
    }

    if (node->data < data)
    {
        node->right = addNode(node->right, data);
    }
    else
    {
        node->left = addNode(node->left, data);
    }
    node = rotate(node);
    return node;
}

int main()
{

    AVLNode *left = new AVLNode(1, nullptr, nullptr);
    AVLNode *right = new AVLNode(3, nullptr, nullptr);
    AVLNode *root = new AVLNode(2, left, right);

    root->left = left;
    root->right = right;
    display(root);
    addNode(root, 4);
    display(root);
}