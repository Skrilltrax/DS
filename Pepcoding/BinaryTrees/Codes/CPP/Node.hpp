#include <climits>
class Node
{

public:
    int data;
    Node *left;
    Node *right;

    Node()
    {
        data = INT_MIN;
        left = nullptr;
        right = nullptr;
    }

    Node(int data)
    {
        this->data = data;
        this->left = left;
        this->right = right;
    }

    Node(int data, Node *left, Node *right)
    {
        this->data = data;
        this->left = left;
        this->right = right;
    }
};