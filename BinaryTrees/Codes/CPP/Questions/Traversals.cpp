#include "../Node.hpp"
#include <iostream>
using namespace std;

void preorder(Node *node)
{
    if (node == nullptr)
        return;

    cout << node->data << endl;

    preorder(node->left);
    preorder(node->right);
}

void postorder(Node *node)
{
    if (node == nullptr)
        return;

    postorder(node->left);
    postorder(node->right);

    cout << node->data << endl;
}

void inorder(Node *node)
{
    if (node == nullptr)
        return;

    inorder(node->left);

    cout << node->data << endl;

    inorder(node->right);
}

int main(int argc, char const *argv[])
{
    Node *node5 = new Node(5);
    Node *node4 = new Node(4);
    Node *node3 = new Node(3);
    Node *node2 = new Node(2, node4, node5);
    Node *node1 = new Node(1, node2, node3);

    preorder(node1);
    cout << endl;
    postorder(node1);
    cout << endl;
    inorder(node1);
    return 0;
}
