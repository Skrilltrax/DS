#include <iostream>
#include <algorithm>
#include "../Node.hpp"
using namespace std;

class BinaryTreeUtils
{
public:
    static int index;

    // * Delete copy constructor, Not related
    BinaryTreeUtils(BinaryTreeUtils const &utils) = delete;

    static Node *createNode(int nodes[])
    {
        if (nodes[index] == -1 || sizeof(nodes) / sizeof(int) == index)
        {
            index++;
            return nullptr;
        }

        Node *currNode = new Node(nodes[index]);
        index++;

        currNode->left = createNode(nodes);
        currNode->right = createNode(nodes);

        return currNode;
    }

    static void createTree(int nodes[])
    {
        BinaryTreeUtils::index = 0;
        createNode(nodes);
    }

    static int getHeight(Node *node)
    {
        if (node == nullptr)
            return 0;

        int leftHeight = getHeight(node->left);
        int rightHeight = getHeight(node->right);

        return std::max(leftHeight, rightHeight) + 1;
    }

    static int getSize(Node *node)
    {
        if (node == nullptr)
            return 0;

        return (getSize(node->left) + getSize(node->right)) + 1;
    }

    static bool findNode(Node *node, int data)
    {
        if (node == nullptr)
            return false;

        return (node->data == data) || findNode(node->left, data) || findNode(node->right, data);
    }
};

int BinaryTreeUtils::index = 0;